package p1;

 
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.CtMethod;
import javassist.NotFoundException;

public class PojoCreatorClass {
    
    private static ClassPool child = null;

    private static ClassPool parent = null;
    
    private static int incrementValue = 1;

    public static CtClass generatePojo(String className, Map  properties, CtClass cc, String packageName) throws NotFoundException, ClassNotFoundException  {
        Class classz = null;        
        packageName = packageName + incrementValue;
        className = packageName +"."+className;
        incrementValue ++;
       System.out.println("in method"); 
        if (parent == null ){
            parent = ClassPool.getDefault();
            child = new ClassPool(parent);
            child.insertClassPath("src");
            System.out.println("in true");    
        }  else {
            cc = child.getOrNull(className);
            if (cc != null)
            classz = Class.forName(className, true, child.getClassLoader());
            System.out.println("in false");
        }
        
        if ( cc != null){
            cc = child.makeClass(className);
           
        try {
        	
        	cc.addInterface(resolveCtClass(Serializable.class));
            System.out.println("in try");
            //    cc.addInterface(resolveCtClass(Cloneable.class));
        //    CtMethod m = CtNewMethod.make(
          //           "public Object clone() throws CloneNotSupportedException { return super.clone(); }",
            //         cc);
        //    cc.addMethod(m);
            Set entrySet = properties.entrySet();
            Iterator itr = entrySet.iterator();
            System.out.println("before while"  + entrySet.size());
            while(itr.hasNext())
            {
            	System.out.println("in while");
            	Entry entry = (Entry) itr.next();	
            	
     cc.addField(new CtField(resolveCtClass(entry.getValue().getClass()), (String) entry.getKey(), cc));

            // add getter
            cc.addMethod(generateGetter(cc , (String) entry.getKey(), (Class) entry.getValue().getClass()));

            // add setter
            cc.addMethod(generateSetter(cc, (String) entry.getKey(), (Class)entry.getValue().getClass()));
        }
        
        cc.addMethod(addToStringMethod(cc));
        //cc.defrost();
        //cc.stopPruning(false);
        
        //System.out.println(cc.toString());
        return cc;
        } catch (NotFoundException e) {
            e.printStackTrace();
        } catch (CannotCompileException e) {
            e.printStackTrace();
            }
        
        }
        System.out.println(cc);
        return cc;
    }

    public static CtClass generate(String className, Map  properties, CtClass cc, String packageName,boolean isFixedWidth) throws NotFoundException, ClassNotFoundException  {
        Class classz = null;
        if(!isFixedWidth)
        packageName = packageName + incrementValue;
        className = packageName +"."+className;
        incrementValue ++;
        
        if (parent == null ){
            parent = ClassPool.getDefault();
            child = new ClassPool(parent);
            child.insertClassPath("src");
            System.out.println("in true");
        }  else {
            cc = child.getOrNull(className);
            if (cc != null)
            classz = Class.forName(className, true, child.getClassLoader());
            System.out.println("false");
        }
        
        if ( cc != null){
            cc = child.makeClass(className);
        try {
            cc.addInterface(resolveCtClass(Serializable.class));
        //    cc.addInterface(resolveCtClass(Cloneable.class));
        //    CtMethod m = CtNewMethod.make(
          //           "public Object clone() throws CloneNotSupportedException { return super.clone(); }",
            //         cc);
        //    cc.addMethod(m);
            Set entrySet = properties.entrySet();
            Iterator itr = entrySet.iterator();
            while(itr.hasNext())
            {
            	Entry entry = (Entry) itr.next();
                cc.addField(new CtField(resolveCtClass((Class) entry.getValue()), (String) entry.getKey(), cc));

                // add getter
                cc.addMethod(generateGetter(cc, (String) entry.getKey(), (Class) entry.getValue()));

                // add setter
                cc.addMethod(generateSetter(cc, (String) entry.getKey(), (Class)entry.getValue()));
        	
            }
        
        cc.addMethod(addToStringMethod(cc));
        //cc.defrost();
        //cc.stopPruning(false);
        
        //System.out.println(cc.toString());
        return cc;
        } catch (NotFoundException e) {
            e.printStackTrace();
        } catch (CannotCompileException e) {
            e.printStackTrace();
            }
        }
        return cc;
    }
    private static CtMethod generateGetter(CtClass declaringClass, String fieldName, Class fieldClass)
            throws CannotCompileException {

        String getterName = "get" + fieldName.substring(0, 1).toUpperCase()
                + fieldName.substring(1);

        StringBuffer sb = new StringBuffer();
        sb.append("public ").append(fieldClass.getName()).append(" ")
                .append(getterName).append("(){").append("return this.")
                .append(fieldName).append(";").append("}");
        return CtMethod.make(sb.toString(), declaringClass);
    }

    private static CtMethod generateSetter(CtClass declaringClass, String fieldName, Class fieldClass)
            throws CannotCompileException {

        String setterName = "set" + fieldName.substring(0, 1).toUpperCase()
                + fieldName.substring(1);

        StringBuffer sb = new StringBuffer();
        sb.append("public void ").append(setterName).append("(")
                .append(fieldClass.getName()).append(" ").append(fieldName)
                .append(")").append("{").append("this.").append(fieldName)
                .append("=").append(fieldName).append(";").append("}");
        return CtMethod.make(sb.toString(), declaringClass);
    }

    private static CtClass resolveCtClass(Class clazz) throws NotFoundException {
        return child.get(clazz.getName());
    }
    
    private static CtMethod addToStringMethod(CtClass declaringClass) throws CannotCompileException{
        StringBuffer sb = new StringBuffer();
        sb.append("public  String toString() {");
        sb.append("return ");
        CtField[] ctFields = declaringClass.getFields();
        for (CtField ctField : ctFields) {
               sb.append("\"\t"+ctField.getName() +" : \t\"+");
               sb.append("this."+ctField.getName()+"+");
        }
        sb.replace(sb.lastIndexOf("+"), sb.lastIndexOf("+")+1, "");
        sb.append(";");
        sb.append("}");
        System.out.println(sb.toString());
        return CtMethod.make(sb.toString(), declaringClass);
  }
} 