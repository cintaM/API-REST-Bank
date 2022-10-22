package com.ironhack.Bank;

import com.ironhack.Bank.entity.AccountsType.Checking;
import com.ironhack.Bank.entity.AccountsType.CreditCards;
import com.ironhack.Bank.entity.Embeddable.Money;
import com.ironhack.Bank.entity.Embeddable.PrimaryAddress;
import com.ironhack.Bank.entity.UsersType.Admins;
import com.ironhack.Bank.entity.UsersType.Holders;
import com.ironhack.Bank.entity.UsersType.ThirdParty;
import com.ironhack.Bank.entity.UsersType.Users;
import com.ironhack.Bank.repositories.AccountsType.CheckingRepository;
import com.ironhack.Bank.repositories.AccountsType.CreditCardsRepository;
import com.ironhack.Bank.respositories.UsersType.AdminsRepository;
import com.ironhack.Bank.respositories.UsersType.HoldersRepository;
import com.ironhack.Bank.respositories.UsersType.ThirdPartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootApplication
public class Application implements CommandLineRunner {
	@Autowired
	AdminsRepository adminsRepository;

	@Autowired
	HoldersRepository holdersRepository;

	@Autowired
	ThirdPartyRepository thirdPartyRepository;
	@Autowired
	CreditCardsRepository creditCardsRepository;


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Admins admin1 = adminsRepository.save(new Admins("Cinta"));
		Holders holders1 = holdersRepository.save(new Holders("Maria",LocalDate.of(1998, 3, 25), new PrimaryAddress("RUA", 2, "Madrid"), "bibibi@gmail.com"));
		ThirdParty thirdParty1 = thirdPartyRepository.save(new ThirdParty("R356XD", "Tienda Manolita"));
		//CreditCards creditCard1 = creditCardsRepository.save(new CreditCards(new Money(BigDecimal.valueOf(1500)), BigDecimal.valueOf(2.5)));







	}
}
