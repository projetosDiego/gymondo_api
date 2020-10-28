package com.gymondo.api.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.gymondo.api.exception.PauseTrialException;
import com.gymondo.api.exception.UserInforNotFoundException;
import com.gymondo.api.exception.VoucherNotFoundException;
import com.gymondo.api.model.SubscriptionPlan;
import com.gymondo.api.model.UserApi;
import com.gymondo.api.model.UserSubscription;
import com.gymondo.api.model.Voucher;
import com.gymondo.api.repository.PurchaseRepository;
import com.gymondo.api.repository.UserRepository;
import com.gymondo.api.repository.VoucherRepository;

@Service
public class PurchaseServiceImpl implements IPurchaseService{
	
	public static final String ACTIVE                  = "active";
	public static final String PAUSED                  = "paused";
	public static final String CANCELED                = "canceled";
	public static final String TRIAL                   = "trial";
	public static final String SUBSCRIPTION_DONE       = "Your subscription is done!";
	public static final String SUBSCRIPTION_PAUSED     = "Your subscription is paused.";
	public static final String SUBSCRIPTION_UNPAUSED   = "Your subscription is unpaused.";
	public static final String SUBSCRIPTION_CANCELED   = "Your subscription is canceled.";
	public static final String VOUCHER_NOT_FOUND       = "Voucher code not found.";
	public static final String PAUSE_TRIAL_EXCEPTION   = "You can not pause a subscription during the trial period.";
	public static final String USER_NOTFOUND_EXCEPTION = "This user does not have purchase informations.";
	
	@Autowired
	public PurchaseRepository purchaseRepository;
	
	@Autowired
	public UserRepository     userRepository;
	
	@Autowired
	public VoucherRepository  voucherRepository;

	@Override
	public String buyPlan(Long userId, Long productId, String voucherCode) {
		UserSubscription userSubscription = new UserSubscription();
		Voucher          voucherBd        = new Voucher();
		if(!voucherCode.equals("0")) {
			try {
				voucherBd = voucherRepository.findVoucherByCode(voucherCode);
				userSubscription.setPrice(voucherBd.getPriceDescount());
				userSubscription.setTax(voucherBd.getPercentDescount());
			} catch (EmptyResultDataAccessException e) {
				throw new VoucherNotFoundException(VOUCHER_NOT_FOUND);
			}
		}
		
		UserApi          userBd = userRepository.findUserById(userId);
		SubscriptionPlan planBd = purchaseRepository.findByProductId(productId);
		
		LocalDateTime trialIni = LocalDateTime.now(); 
		LocalDateTime trialFin = trialIni.plusMonths(1);
		
		LocalDateTime ini = trialFin.plusDays(1); 
		LocalDateTime fin = ini.plusMonths(planBd.getDuration());
		
		populateUserSubscription(userSubscription, userBd, planBd, ini, fin, trialIni, trialFin);
		
		purchaseRepository.insert(userSubscription);
		return SUBSCRIPTION_DONE;
	}

	private void populateUserSubscription(UserSubscription userSubscription, UserApi userBd, SubscriptionPlan planBd,
			LocalDateTime ini, LocalDateTime fin, LocalDateTime trialIni, LocalDateTime trialFin) {
		userSubscription.setUserId(userBd.getUserId());
		userSubscription.setUserName(userBd.getUserName());
		userSubscription.setPlanId(planBd.getPlanId());
		userSubscription.setPlanName(planBd.getPlanName());
		userSubscription.setDateIni(Timestamp.valueOf(ini));
		userSubscription.setDateFin(Timestamp.valueOf(fin));
		userSubscription.setDuration(planBd.getDuration());
		userSubscription.setPrice(planBd.getPrice() - (userSubscription.getPrice() != null ? userSubscription.getPrice() : 0));
		userSubscription.setTax(planBd.getTax() - (userSubscription.getTax() != null ? userSubscription.getTax() : 0));
		userSubscription.setTrialDateIni(Timestamp.valueOf(trialIni));
		userSubscription.setTrialDateFin(Timestamp.valueOf(trialFin));
		userSubscription.setSubscriptionStatus(TRIAL);
	}

	@Override
	public String pauseSubscription(Long userId) {
		UserSubscription userSubscriptionBd = purchaseRepository.findByUserId(userId);
		if(userSubscriptionBd.getSubscriptionStatus().equals(TRIAL)) {
			throw new PauseTrialException(PAUSE_TRIAL_EXCEPTION);
		}
		userSubscriptionBd.setSubscriptionStatus(PAUSED);
		
		userSubscriptionBd.setPauseDate(Timestamp.valueOf(LocalDateTime.now()));
		
		purchaseRepository.update(userSubscriptionBd);
		return SUBSCRIPTION_PAUSED;
	}

	@Override
	public String unpouseSubscription(Long userId) {
 		UserSubscription userSubscriptionBd = purchaseRepository.findByUserId(userId);
		userSubscriptionBd.setSubscriptionStatus(ACTIVE);
		
		Long          daysBetween = ChronoUnit.DAYS.between(userSubscriptionBd.getPauseDate().toLocalDateTime(), LocalDateTime.now());
		LocalDateTime dateFinAux  = userSubscriptionBd.getDateFin().toLocalDateTime();
		
		userSubscriptionBd.setDateFin(Timestamp.valueOf(dateFinAux.plusDays(daysBetween)));
		purchaseRepository.update(userSubscriptionBd);
		return SUBSCRIPTION_UNPAUSED;
	}

	@Override
	public String cancelSubscription(Long userId) {
		UserSubscription userSubscriptionBd = purchaseRepository.findByUserId(userId);
		purchaseRepository.delete(userSubscriptionBd.getUserSubscriptionId());
		return SUBSCRIPTION_CANCELED;
	}

	@Override
	public UserSubscription userSubscriptionInfo(Long userId) {
		try {
			return purchaseRepository.findByUserId(userId);
		} catch (EmptyResultDataAccessException e) {
			throw new UserInforNotFoundException(USER_NOTFOUND_EXCEPTION);
		}
	}

}
