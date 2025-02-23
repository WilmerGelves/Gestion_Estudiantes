package com.gestionestudiante;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Iterator;
public class Main {
    public static void main(String[] args) {
        gestioAlumnos();
    }

    public static void gestioAlumnos(){
        try {
            List<String> estudiantes = new ArrayList<>(); //Se creo la lista. 
            String nombreAlumno;
            @SuppressWarnings("resource")
            Scanner sc = new Scanner(System.in); //buffer de entrada 

            System.out.print("Ingrese la cantidad de estudiantes:\n ->  ");
            int cantAlumnos = sc.nextInt();
            sc.nextLine();
            for(int i = 0; i < cantAlumnos ;i++){ //Se hace el recoerido mediante un for 
                System.out.print("Alumno N° " + (i+1) +": ");
                nombreAlumno = sc.nextLine().toLowerCase().trim();
                estudiantes.add(nombreAlumno);
            }

            System.out.println("\nListado de Estudiantes: ");
            Iterator<String> iterator = estudiantes.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }

            // Ordenando la lista alfabéticamente con Collections.sort()
            Collections.sort(estudiantes);

            System.out.println("\nListado ordenado alfabeticamente:");
            int i = 0;
            for (String estudiante : estudiantes) { //Haciendo uso del for-each
                i++;
                System.out.printf("N° %d : %s\n",i,estudiante);
            }

            //Busqueda de un estudiante en específico.
            System.out.print("Nombre del estudiante a buscar: \n -> ");
            nombreAlumno = sc.nextLine().toLowerCase().trim();

            boolean existeNombre = estudiantes.contains(nombreAlumno);//Buqueda con el método contains()
            if (existeNombre == true) {
                System.out.printf("El estdudiante %s se encuentra en la lista. ",nombreAlumno);
            }else{
                System.out.printf("El estdudiante %s no encuentra en la lista. ",nombreAlumno);
            }
        } catch (Exception e) {
            System.out.println("Ha ingresado caracteres erroneos, intentelo nuevamente.\n");
            gestioAlumnos();
        }
    }
}