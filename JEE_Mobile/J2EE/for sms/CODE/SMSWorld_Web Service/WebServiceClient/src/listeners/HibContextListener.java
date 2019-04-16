package listeners;

import java.util.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.hibernate.SessionFactory;

import utils.HibernateUtils;

public class HibContextListener implements ServletContextListener
{
	private SessionFactory sf;

    public void contextInitialized(ServletContextEvent sce) 
    {
        sf=HibernateUtils.getFactory();

        ServletContext sc=sce.getServletContext();
		
		List<String> gender=Arrays.asList("Male","Female");
		sc.setAttribute("gender", gender);	
		/*
		HashMap<String, List<String>> state=new HashMap<String, List<String>>();
		ArrayList<String> list=new ArrayList<String>();
		list.add("Pune");
		list.add("Satara");
		list.add("Solapur");
		list.add("Alibag");
		state.put("MH", list);
		ArrayList<String> list1=new ArrayList<String>();
		list1.add("Indore");
		list1.add("Bhopal");
		list1.add("Jabalpur");
		state.put("MP", list1);
		ArrayList<String> list2=new ArrayList<String>();
		list2.add("Mohali");
		list2.add("Chandighar");
		list2.add("pqr");
		list2.add("xyz");
		state.put("Punjab", list2);
		sc.setAttribute("state",state);	*/
		ArrayList<String> state=new ArrayList<String>();
		state.add("<-- State -->");
		state.add("MH");
		state.add("MP");
		state.add("Punjab");
		state.add("Colcata");
		state.add("Chennai");
		sc.setAttribute("state",state);
		
		ArrayList<String> city=new ArrayList<String>();
		city.add("<-- City -->");
		city.add("Pune");
		city.add("Satara");
		city.add("Mohali");
		city.add("Chandighar");
		
		sc.setAttribute("city",city);
		
		List<String> que=Arrays.asList("<-- Question -->","Who is Your Best Friend?","Which is you favourite Color?","Who is Your Best Teacher?");
		sc.setAttribute("que", que);
		
		
 //Template Messages
		
		//Jokes
        HashMap<Integer,String> jokes=new HashMap<Integer, String>();
        jokes.put(1,"Teacher:Tintu what is the full form of class? Tintumon:C-Come L-Late A-And S-Start S-Sleeping");
        jokes.put(2,"My Attitude :- A Boy proposed to me. And I said: Sorry, I won`t accept your proposal, But I apprecate your selection...!");
        jokes.put(3,"One Crack love with a nurse. HE writes love letter. He writes,I Love you Sister.");
        jokes.put(4,"An exact Definition OF Mathematics: Mathematics is study of finding a black CAT in a dark room... When there is no CAT actually.. ");
        jokes.put(5,"Teacher:What is difference between Orange and Apple Crack:The color of Orange is Orange and the Color of Apple is not apple..");
        sc.setAttribute("jokes",jokes);
        
        //Good Morning 
        HashMap<Integer,String> gudmrng=new HashMap<Integer, String>();
        gudmrng.clear();
        gudmrng.put(1,"Why the sun sets and rise every day ????Socho socho !??So that u can wish good morning and good evening to your loving ones! ");
        gudmrng.put(2,"Mornings are refreshing like friendship, it may not stay all day long, but for sure it comes forever every day. Good Morning");
        gudmrng.put(3,"welcome every day as a new day, special day, good day, wondwerful day and happy day. enjoy every part of the whole day.");
        gudmrng.put(4,"As u rise up to start a nu dy may the glory of God guide u and bring u tour blessings. gud morning");
        gudmrng.put(5,"Sun spread rays,star close eyes, moon windup his cool brightness, open your eyes and spread smile to make day bright. Good Morning ");
        sc.setAttribute("gudmrng",gudmrng);
    	
        //BirthDay Wish
    	HashMap<Integer,String> birthday=new HashMap<Integer, String>();
    	birthday.clear();
    	birthday.put(1,"Bcos today is your day, its an opportunity for u to know that u are special and special things are for u today happy Birth Day");
    	birthday.put(2,"Wish you a very happy birthday, May life lead you 2 great happiness, success and hope dat all your wishes");
    	birthday.put(3,"Happiness as light as air. LOVE as DEEP as OCEAN. Friends as solid as diamonds and success as bright as gold. Happy Birth Day ");
    	birthday.put(4,"Every thing straight and wipes rinkle away hope you share a lots receive a lots for days to come happy birthday");
    	birthday.put(5,"Today, when a sweet soul was born, I wish to bless you with my love and care, and promise to never disappoint you. Happy Birth Day");
    	sc.setAttribute("birthday",birthday);

    }

    public void contextDestroyed(ServletContextEvent arg0) {
        if (sf != null)
        	sf.close();
    }
	
}
