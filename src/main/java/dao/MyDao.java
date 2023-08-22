package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.transaction.Transaction;

import dto.CoustomerSignUp;

public class MyDao {
EntityManagerFactory e=Persistence.createEntityManagerFactory("dev");
EntityManager m=e.createEntityManager();
EntityTransaction t=m.getTransaction();

public void save(CoustomerSignUp Coustomer) {
	t.begin();
	m.persist(Coustomer);
	t.commit();
}

public  CoustomerSignUp fetchByEmail(String email) {
	Query query=m.createQuery("select x from CoustomerSignUp x where email=?1").setParameter(1, email);
	List<CoustomerSignUp>list=query.getResultList();
	if(list.isEmpty()) {
		return null;
	}else {
		return list.get(0);
	}
}


public  CoustomerSignUp fetchByMobile(long mobile) {
	Query query=m.createQuery("select x from CoustomerSignUp x where email=?1").setParameter(1, mobile);
	List<CoustomerSignUp>list=query.getResultList();
	if(list.isEmpty()) {
		return null;
	}else {
		return list.get(0);
	}
}


}

