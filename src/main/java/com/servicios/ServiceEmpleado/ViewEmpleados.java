package com.servicios.ServiceEmpleado;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zul.Messagebox;
import com.google.gson.Gson;
import com.servicios.ServiceEmpleado.entity.Empleado;


public class ViewEmpleados {
	private Empleado selectedItem;
	private Integer selectedItemIndex;
	private ArrayList<Empleado> showEmpleados = new ArrayList<Empleado>();

	public Integer getSelectedItemIndex() {
		return selectedItemIndex;
	}

	public void setSelectedItemIndex(Integer selectedItemIndex) {
		this.selectedItemIndex = selectedItemIndex;
	}

	public Empleado getSelectedItem() {
		return selectedItem;
	}

	public void setSelectedItem(Empleado selectedItem) {
		this.selectedItem = selectedItem;
	}

	public ArrayList<Empleado> getShowEmpleados() {
		return showEmpleados;
	}

	public void setShowEmpleados(ArrayList<Empleado> showEmpleados) {
		this.showEmpleados = showEmpleados;
	}

	@Init
	public void init() {
		System.out.println("arg1: " + "hola");
	}

	@AfterCompose
	public void initSetup(@ContextParam(ContextType.VIEW) Component view) {
		Selectors.wireComponents(view, this, false);
		HttpURLConnection conn = null;

		try {
			URL url = new URL("http://localhost:8095/api/empleados");
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			try {
				if (conn.getResponseCode() != 200) {
					Messagebox.show("No se establecio conexión",
							String.valueOf(conn.getResponseCode()),
							Messagebox.OK, Messagebox.ERROR);
					throw new RuntimeException("Failed : HTTP error code : "
							+ conn.getResponseCode());
				}

			} catch (Exception e) {
				Messagebox
						.show("No se establecio conexión"
								+ "Revise la configuracion del restApi:",
								"Exception DataSource", Messagebox.OK,
								Messagebox.ERROR);
				conn.disconnect();

				return;
			}
			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			String json = "";
			while ((output = br.readLine()) != null) {

				json = output;
			}

			Gson gson = new Gson();
			Empleado[] list = gson.fromJson(json, Empleado[].class);
			System.out.println(list.toString());
			for (Empleado empleado : list) {
				System.out.println(empleado.getNombre());
				showEmpleados.add(empleado);
			}

			conn.disconnect();

		} catch (Exception err) {
			System.out.println("Error Exception:" + err.getLocalizedMessage());
		}

		finally {
			conn = null;

		}
	}
}
