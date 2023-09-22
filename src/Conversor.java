import javax.swing.*;

public class Conversor {
	public static void main(String[] args) {
		String[] opciones = { "Conversor de Divisas", "Conversor de Temperatura", "Salir" };
		String opcionSeleccionada = "";

		while (!opcionSeleccionada.equals("Salir")) {
			opcionSeleccionada = (String) JOptionPane.showInputDialog(null, "Selecciona una opción:", "Conversor",
					JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);

			if (opcionSeleccionada != null) {
				if (opcionSeleccionada.equals("Conversor de Divisas")) {
					ejecutarConversorDeDivisas();
				} else if (opcionSeleccionada.equals("Conversor de Temperatura")) {
					ejecutarConversorDeTemperatura();
				} else if (opcionSeleccionada.equals("Conversor de Temperatura")) {
					System.exit(0);;
				}
			}
		}
	}

	public static void ejecutarConversorDeDivisas() {
		String[] monedas = { "Dólar", "Euros", "Libras Esterlinas", "Yen Japonés", "Won sul-coreano" };
		String monedaOrigen = (String) JOptionPane.showInputDialog(null, "Selecciona la moneda de origen:",
				"Conversor de Divisas", JOptionPane.PLAIN_MESSAGE, null, monedas, monedas[0]);

		String cantidadStr = JOptionPane.showInputDialog("Introduce la cantidad a convertir:");
		double cantidad = Double.parseDouble(cantidadStr);

		String monedaDestino = (String) JOptionPane.showInputDialog(null, "Selecciona la moneda de destino:",
				"Conversor de Divisas", JOptionPane.PLAIN_MESSAGE, null, monedas, monedas[0]);

		double tasaDeConversion = obtenerTasaDeConversion(monedaOrigen, monedaDestino);

		if (tasaDeConversion > 0) {
			double resultado = cantidad * tasaDeConversion;
			JOptionPane.showMessageDialog(null,
					cantidad + " " + monedaOrigen + " equivale a " + resultado + " " + monedaDestino, "Resultado",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Tasa de conversión no válida", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void ejecutarConversorDeTemperatura() {
		String[] opciones = { "Celsius a Fahrenheit", "Fahrenheit a Celsius", "Celsius a Kelvin", "Kelvin a Celsius" };
		String opcionSeleccionada = (String) JOptionPane.showInputDialog(null,
				"Selecciona una opción de conversión de temperatura:", "Conversor de Temperatura",
				JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);

		if (opcionSeleccionada != null) {
			String temperaturaStr = JOptionPane.showInputDialog("Introduce la temperatura:");
			double temperatura = Double.parseDouble(temperaturaStr);
			double resultado = 0;

			if (opcionSeleccionada.equals("Celsius a Fahrenheit")) {
				resultado = celsiusAFahrenheit(temperatura);
			} else if (opcionSeleccionada.equals("Fahrenheit a Celsius")) {
				resultado = fahrenheitACelsius(temperatura);
			} else if (opcionSeleccionada.equals("Celsius a Kelvin")) {
				resultado = celsiusAKelvin(temperatura);
			} else if (opcionSeleccionada.equals("Kelvin a Celsius")) {
				resultado = kelvinACelsius(temperatura);
			}

			JOptionPane.showMessageDialog(null,
					temperatura + " grados " + opcionSeleccionada.substring(0, opcionSeleccionada.indexOf(" a "))
							+ " equivalen a " + resultado + " grados "
							+ opcionSeleccionada.substring(opcionSeleccionada.indexOf(" a ") + 3),
					"Resultado", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public static double obtenerTasaDeConversion(String monedaOrigen, String monedaDestino) {
		
		// Ingresa manualmente las tasas de conversión aquí
		// Estas son solo tasas de conversión de ejemplo
		
		if (monedaOrigen.equals("Dólar") && monedaDestino.equals("Euros")) {
			return 0.85;
		} else if (monedaOrigen.equals("Dólar") && monedaDestino.equals("Libras Esterlinas")) {
			return 0.72;
		} else if (monedaOrigen.equals("Dólar") && monedaDestino.equals("Yen Japonés")) {
			return 110.35;
		} else if (monedaOrigen.equals("Dólar") && monedaDestino.equals("Won sul-coreano")) {
			return 1156.75;
		} else if (monedaOrigen.equals("Euros") && monedaDestino.equals("Dólar")) {
			return 1.18; // Cambia esta tasa a la tasa de conversión actual
		} else if (monedaOrigen.equals("Euros") && monedaDestino.equals("Libras Esterlinas")) {
			return 0.85; // Cambia esta tasa a la tasa de conversión actual
		} else if (monedaOrigen.equals("Euros") && monedaDestino.equals("Yen Japonés")) {
			return 130.65; // Cambia esta tasa a la tasa de conversión actual
		} else if (monedaOrigen.equals("Euros") && monedaDestino.equals("Won sul-coreano")) {
			return 1375.95; // Cambia esta tasa a la tasa de conversión actual
		}
		// Agrega más tasas de conversión según sea necesario

		return -1; // Devuelve un valor negativo si la tasa de conversión no es válida
	}

	public static double celsiusAFahrenheit(double celsius) {
		return (celsius * 9 / 5) + 32;
	}

	public static double fahrenheitACelsius(double fahrenheit) {
		return (fahrenheit - 32) * 5 / 9;
	}

	public static double celsiusAKelvin(double celsius) {
		return celsius + 273.15;
	}

	public static double kelvinACelsius(double kelvin) {
		return kelvin - 273.15;
	}
}
