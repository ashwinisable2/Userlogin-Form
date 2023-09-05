package in.user.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import in.user.bindings.LoginForm;
import in.user.bindings.UserForm;
import in.user.constants.AppConstants;
import in.user.entities.CitiesMasterEntity;
import in.user.entities.CountryMasterEntity;
import in.user.entities.StateMasterEntity;
import in.user.entities.UserAccountEntity;
import in.user.props.AppProperties;
import in.user.repositories.CitiesRepo;
import in.user.repositories.CountryRepo;
import in.user.repositories.StatesRepo;
import in.user.repositories.UserAccountRepo;



@Service
public class  UserServiceImpl implements UserService {
	
	private UserAccountRepo userAccRepo;
	
	private CountryRepo countryRepo;
	
	private StatesRepo stateRepo;
	
	private CitiesRepo citiesRepo;
	
	
	private AppProperties appProps;
	
	public UserServiceImpl(UserAccountRepo userAccRepo,CountryRepo countryRepo,StatesRepo stateRepo,CitiesRepo citiesRepo,AppProperties appProps) {
	
		this.userAccRepo=userAccRepo;
		this.countryRepo=countryRepo;
		this.stateRepo=stateRepo;
		this.citiesRepo=citiesRepo;
		
		
	}
	
	
	@Override
	public String loginCheck(LoginForm loginForm) {
		UserAccountEntity userAcc = userAccRepo.findByEmailAndPassword(loginForm.getEmail(),loginForm.getPassword());
		if(userAcc!=null){
			String accStatus = userAcc.getAccStatus();
			
			if(accStatus.equals(AppConstants.LOCKED)){
				return appProps.getMessages().get(AppConstants.ACCOUNT_LOCKED);
			}
			else{
				return AppConstants.SUCCESS;
			}
		}
		else {
			return appProps.getMessages().get(AppConstants.INVALID_CREDENTIALS);
	}
}

	@Override
	public Map<Integer, String> getCountries() {
		
		List<CountryMasterEntity> countries = countryRepo.findAll();
		
		Map<Integer,String> countryMap=new HashMap<>();
		countries.forEach(country->{
			countryMap.put(country.getCountryId(),country.getCountryName());
		});
		return countryMap;
	}

	@Override
	public Map<Integer, String> getStates(Integer countryId) {
		List<StateMasterEntity> states = stateRepo.findByCountryId(countryId);
		Map<Integer, String> statesMap=new HashMap<>();
		
		states.forEach(state->{
			statesMap.put(state.getStateId(),state.getStateName());
		});   
		return statesMap;
	}

	@Override
	public Map<Integer, String> getCities(Integer stateId) {
		
		Map<Integer,String> citiesMap=new HashMap<>();
		
		List<CitiesMasterEntity> cities = citiesRepo.findByStateId(stateId);
		
		cities.forEach(city->{
			citiesMap.put(city.getCityId(), city.getCityName());
		});
		return citiesMap;
		
		
	}

	@Override
	public boolean emailUnique(String email) {
		UserAccountEntity user = userAccRepo.findByEmail(email);
		if(user==null)
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean saveUser(UserForm userForm) {
		
		userForm.setAccStatus(AppConstants.LOCKED);
		userForm.setPassword(generateTempPassword());
		
		UserAccountEntity entity=new UserAccountEntity();
		
		BeanUtils.copyProperties(userForm, entity);
		
		UserAccountEntity save = userAccRepo.save(entity);
		
		
		if(save.getUserId()!=null)
		{
			//TODO:Logic to send email to Unlock the Account

			
			return true;
		}
		
		return false;
	}

	
	@Override
	public String forgotPwd(String emailId) {

		UserAccountEntity user= userAccRepo.findByEmail(emailId);
		
		if(user!=null)
		{
		
			
			return appProps.getMessages().get(AppConstants.FOROT_PWD_SUCCESS);
			
		}
		return appProps.getMessages().get( AppConstants.FORGOT_PWD_FAIL);
	}
	
	private String generateTempPassword() {
		//logic to generate password
		String randomText = RandomStringUtils.randomAlphanumeric(6);
		return randomText;
		
	}
	
	
	
}

