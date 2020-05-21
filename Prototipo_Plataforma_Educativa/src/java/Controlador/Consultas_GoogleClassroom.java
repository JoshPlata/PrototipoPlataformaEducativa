package Controlador;


import Modelo.Credenciales_GoogleClassroom;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpResponseException;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
//import com.google.api.client.json.GoogleJsonResponseException;
//import com.google.api.client.json.GoogleJsonError;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.classroom.ClassroomScopes;
import com.google.api.services.classroom.model.*;
import com.google.api.services.classroom.Classroom;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;


public class Consultas_GoogleClassroom {
    private static final String APPLICATION_NAME = "Creando Salones";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
     
    public Consultas_GoogleClassroom(){
        
    }
    
    public void Invitar_Profesor(String Nombre_Aula,String Email_Profesor) throws IOException, GeneralSecurityException {
        // Build a new authorized API client service.
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        Classroom service = new Classroom.Builder(HTTP_TRANSPORT, JSON_FACTORY, Credenciales_GoogleClassroom.getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();
       
        ListCoursesResponse response = service.courses().list()
                .setPageSize(10)
                .execute();

        List<Course> courses = response.getCourses();
        if (courses == null || courses.size() == 0) {
            System.out.println("No courses found.");
        } else {
            System.out.println("Courses:");
            for (Course course : courses) {
                System.out.println(course.getName());

                if (course.getName().equals(Nombre_Aula)){
                    System.out.println("Encontro :" +course.getId());
                    String courseId = course.getId();

                            String teacherEmail = Email_Profesor;                           
                           try{
                            Invitation invitacion= new Invitation()
                            .setRole("TEACHER")
                            .setCourseId(courseId)                            
                            .setUserId(teacherEmail);
                            invitacion=service.invitations().create(invitacion).execute();
                            } catch (GoogleJsonResponseException e) {
                              System.err.println(e.getDetails());
                            }
                            
                }
            }
        }
    }
    
    public void Crear_Curso(String Nombre_Curso,String Desc_Head,String Desc,String Room,String Owner) throws IOException, GeneralSecurityException {
        // Build a new authorized API client service.
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        Classroom service = new Classroom.Builder(HTTP_TRANSPORT, JSON_FACTORY, Credenciales_GoogleClassroom.getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();
        
        //Crear Curso
        Course course = new Course()
        .setName(Nombre_Curso)               
        .setDescriptionHeading(Desc_Head)
        .setDescription(Desc)
        .setRoom(Room)
        .setOwnerId(Owner)
        .setCourseState("PROVISIONED");
        course = service.courses().create(course).execute();
        System.out.printf("Course created: %s (%s)\n", course.getName(), course.getId());
                
    }
}
