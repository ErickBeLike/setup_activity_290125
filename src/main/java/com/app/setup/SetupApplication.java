package com.app.setup;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SetupApplication extends Application {

	public static void main(String[] args) {
		// Inicia Spring Boot en un hilo separado
		Thread springThread = new Thread(() -> SpringApplication.run(SetupApplication.class, args));
		springThread.setDaemon(true);
		springThread.start();

		// Esperar a que el servidor esté listo antes de lanzar JavaFX
		esperarSpringBoot();

		// Inicia JavaFX
		launch(args);
	}

	private static void esperarSpringBoot() {
		boolean iniciado = false;
		while (!iniciado) {
			try {
				Thread.sleep(3000); // Esperar 3 segundos antes de reintentar
				java.net.HttpURLConnection connection =
						(java.net.HttpURLConnection) new java.net.URL("http://localhost:8080/").openConnection();
				connection.setRequestMethod("HEAD");
				connection.connect();
				iniciado = (connection.getResponseCode() == 200);
			} catch (Exception e) {
				System.out.println("Esperando a que el servidor Spring Boot se inicie...");
			}
		}
	}

	@Override
	public void start(Stage primaryStage) {
		WebView webView = new WebView();
		webView.getEngine().load("http://localhost:8080/");

		Scene scene = new Scene(webView, 1280, 720);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Dashboard");
		primaryStage.show();
	}
}