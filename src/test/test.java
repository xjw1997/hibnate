package test;

import entity.House;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class test {
    public static void main(String[] args){
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        List<House> list = session.createCriteria(House.class,"h")
                .add(Restrictions.gt("h.price", 200))
                .addOrder(Order.asc("h.price"))
                .addOrder(Order.desc("h.pubdate"))
                .setFirstResult(0)
                .setMaxResults(2)
                .createCriteria("h.typesByTypeid","t")
                .add(Restrictions.eq("t.name", "两室一厅"))
                .createCriteria("h.streetByStreetid","s").createCriteria("s.districtByDistrictid","d")
                .add(Restrictions.eq("d.name", "海淀")).list();
        for (House house : list) {
            System.out.println(house.getId());

        }
    }
}
