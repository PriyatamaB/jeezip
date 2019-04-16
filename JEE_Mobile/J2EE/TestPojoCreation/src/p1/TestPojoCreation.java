package p1;

import java.util.HashMap;
import java.util.Map;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.NotFoundException;

public class TestPojoCreation {

	/**
	 * @param args
	 * @throws NotFoundException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, NotFoundException {
		// TODO Auto-generated method stub
		PojoCreatorClass pojos = new PojoCreatorClass();
		Map<String, String> map = new HashMap<String,String>();
		map.put("String", "empName");
		ClassPool pool = ClassPool.getDefault();
		pool.insertClassPath("src");
		CtClass cc = pool.makeClass("First");
		
		PojoCreatorClass.generatePojo("First", map,cc, "p1");
		System.out.println("here");
	}

}
