package liwei.hotel;
/** 
 *   酒店的员工类
 *      员工共性：姓名，工号，工作方法
 *  */
public abstract class Employyee {
   private String name;
   private String id;
   public Employyee(){}
   public Employyee(String name, String id) {
	   this.name = name;
	   this.id = id;
   }
   public abstract void work();
   
   public String getName() {
	   return name;
   }
   public void setName(String name) {
	this.name = name;
   }
   public String getId() {
	return id;
   }
   public void setID(String id) {
	this.id = id;
   }
   
   
}
