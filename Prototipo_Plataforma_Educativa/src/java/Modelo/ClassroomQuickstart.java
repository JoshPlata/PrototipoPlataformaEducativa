/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


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


public class ClassroomQuickstart {
    private static final String APPLICATION_NAME = "Creando Salones";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final String TOKENS_DIRECTORY_PATH = "tokens";

    /**
     * Global instance of the scopes required by this quickstart.
     * If modifying these scopes, delete your previously saved tokens/ folder.
     */
    
    //private static final List<String> SCOPES = Collections.singletonList(ClassroomScopes.CLASSROOM_ROSTERS,ClassroomScopes.CLASSROOM_COURSES);
    private static final String CREDENTIALS_FILE_PATH = "../Gradle/credentials.json";

    /**
     * Creates an authorized Credential object.
     * @param HTTP_TRANSPORT The network HTTP Transport.
     * @return An authorized Credential object.
     * @throws IOException If the credentials.json file cannot be found.
     */
    private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException {
        // Load client secrets.
        
         List<String> SCOPES =new ArrayList<String>();
        SCOPES.add(ClassroomScopes.CLASSROOM_COURSES_READONLY);
        SCOPES.add(ClassroomScopes.CLASSROOM_COURSES);
        SCOPES.add(ClassroomScopes.CLASSROOM_ROSTERS);
        InputStream in = ClassroomQuickstart.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
        if (in == null) {
            throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH);
        }
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
                .setAccessType("offline")
                .build();
        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
        return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
    }

    public static void main(String... args) throws IOException, GeneralSecurityException {
        // Build a new authorized API client service.
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        Classroom service = new Classroom.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();

       /* 
        //Crear Curso
        Course course = new Course()
        .setName("Prueba 3")               
        .setDescriptionHeading("Welcome to 10th Grade Biology")
        .setDescription("We'll be learning about about the structure of living creatures "
                + "from a combination of textbooks, guest lectures, and lab work. Expect "
                + "to be excited!")
        .setRoom("20")
        .setOwnerId("me")
        .setCourseState("PROVISIONED");
        course = service.courses().create(course).execute();
        System.out.printf("Course created: %s (%s)\n", course.getName(), course.getId());
    
*/
        
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

                if (course.getName().equals("Prueba 5")){
                    System.out.println("Encontro :" +course.getId());
                    String courseId = course.getId();

                            String teacherEmail = "mauriciocervantesdelgadillo10@gmail.com";                           
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
}
