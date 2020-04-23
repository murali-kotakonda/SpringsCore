package constrInjectMap;

public class TestSingleton {
	public static void main(String[] args) {
		RegistrationSingleton obj1 = RegistrationSingleton.getObject();
		RegistrationSingleton obj2 = RegistrationSingleton.getObject();
		RegistrationSingleton obj3 = RegistrationSingleton.getObject();
		RegistrationSingleton obj4 = RegistrationSingleton.getObject();
		RegistrationSingleton obj5 = RegistrationSingleton.getObject();
		
		System.out.println();
		
	}
}
