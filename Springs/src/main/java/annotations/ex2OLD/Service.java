package annotations.ex2OLD;

public class Service {
	private String msg;
	private Dao dao;
	
	
	public void init(){
		System.out.println("init");
	}
	
	
	public void close(){
		System.out.println("close");
	}
	public void getMessage() {
		System.out.println("Your Message : " + msg);
	}
	public void process(){
		System.out.println("processing");
		dao.save();
	}

	public Service(String msg, Dao dao) {
		super();
		this.msg = msg;
		this.dao = dao;
	}
	
}
