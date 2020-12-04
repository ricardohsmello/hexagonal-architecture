package br.com.ricas;

import br.com.ricas.model.Account;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;

public class AccountRepositoryImplTest {


//    @Test
//    public void should_save_balance_in_database() {
//        account.name("Bradesco");
//        account.balance(2500.0);
//
//        AccountRepositoryJpa accountRepositoryJpa = mock(AccountRepositoryJpa.class);
//
//        when(accountRepositoryJpa.save(AccountMapper.toAccountEntity(account.build())))
//                .thenReturn(AccountMapper.toAccountEntity(getAccountExample()));
//
//        AccountRepositoryImpl accountBusiness = new AccountRepositoryImpl(accountRepositoryJpa);
//        Optional<Account> byId = accountBusiness.findById(UUID.fromString("b6963327-a431-4d96-8030-d3cf1c1c9805"));
//
//        if (byId.isEmpty())
//            fail("Failed to retrieve account");
//
//        assertEquals(account.build(), byId.get());
//    }
//
//    private Account getAccountExample() {
//        return new Account(UUID.fromString("b6963327-a431-4d96-8030-d3cf1c1c9805"), "Bradesco", 2500.0);
//    }

    /*@Test
	public void testFindTheGreatestFromAllData() {
		DataService dataServiceMock = mock(DataService.class);
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 24, 15, 3 });
		SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceMock);
		int result = businessImpl.findTheGreatestFromAllData();
		assertEquals(24, result);
	}*/
}


