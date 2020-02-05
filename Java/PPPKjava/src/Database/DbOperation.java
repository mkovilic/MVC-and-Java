package Database;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Iterator;
import java.util.List;

public class DbOperation {

    public void IspisSvih(){

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");// populates the data of the
        // configuration file

        // creating seession factory object
        SessionFactory factory = cfg.buildSessionFactory();

        // creating session object
        Session session = factory.openSession();

        // creating transaction object
        Transaction t = session.beginTransaction();

        Criteria criteria = session.createCriteria(PutniNalogEntity.class);
        List employees = criteria.list();

        Iterator itr = employees.iterator();
        while (itr.hasNext()) {

            PutniNalogEntity emp = (PutniNalogEntity) itr.next();
            System.out.println("ID:"+ emp.getIdPutniNalog());
            System.out.println("Opis:"+emp.getOpis());
            System.out.println("Iznos dnevnice:"+emp.getIznosDnevnice());
            System.out.println("Broj dnevnice:"+emp.getBrojDnevnica());
            System.out.println("Broj sati:"+emp.getBrojSati());
            System.out.println("Datum dolaska:"+emp.getDatumDolaska());
            System.out.println("Datum odlaska:"+emp.getDatumOdlaska());
        }
        t.commit();
        System.out.println("Data displayed");
        factory.close();
    }

}
