package security;

/**
 * This Class will set the Temperature for the boiler with validating the inputs
 * 
 *
 */
class BoilerManagerWithValidation {

	/**
	 * private native method whose definition was written in C.
	 * 
	 * @param boilerId
	 * @param temperature
	 */
	private native void setTemperature(String boilerId, int temperature);

	// loading the shared object/dll file from library
	static {
		System.loadLibrary("setTemperature");
	}

	public static void main(String[] arguments) {
		if (arguments.length == 2) {
			try {
				BoilerManagerWithValidation boilerManager = new BoilerManagerWithValidation();
				String boilerId = arguments[0];
				int temperature = Integer.parseInt(arguments[1]);

				// validating inputs before calling native method
				boilerManager.validateAndSetTemperature(boilerId, temperature);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Enter two Arguments.\nBoilerId and Temperature\nEg:B001 40");
		}
	}

	/**
	 * Validates the inputs. If the inputs are valid, calls the native method. Else,
	 * display error message
	 * 
	 * @param boilerId
	 * @param temperature
	 */
	public void validateAndSetTemperature(String boilerId, int temperature) {
		if (temperature > 100 && temperature < 300 && boilerId.trim().matches("B\\d+")) {
			setTemperature(boilerId, temperature);
		} else {
			System.out.println(
					"Temperature must between 100 and 300. (or) Boiler Id must be in the format of B followed by any digits");
		}
	}
}