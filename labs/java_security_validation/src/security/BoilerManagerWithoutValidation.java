package security;

/**
 * This Class will set the Temperature for the boiler without validating the
 * inputs
 * 
 *
 */
public class BoilerManagerWithoutValidation {

	/**
	 * public native method whose definition was written in C.
	 * 
	 * @param boilerId
	 * @param temperature
	 */
	public native void setTemperature(String boilerId, int temperature);

	// loading the shared object/dll file from library
	static {
		System.loadLibrary("setTemperature");
	}

	public static void main(String[] arguments) {
		if (arguments.length == 2) {
			try {
				BoilerManagerWithoutValidation boilerManager = new BoilerManagerWithoutValidation();
				String boilerId = arguments[0];
				int temperature = Integer.parseInt(arguments[1]);
				// calling the native method without validating the inputs
				boilerManager.setTemperature(boilerId, temperature);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Enter two Arguments.\nBoilerId and Temperature\nEg:B001 40");
		}
	}

}
