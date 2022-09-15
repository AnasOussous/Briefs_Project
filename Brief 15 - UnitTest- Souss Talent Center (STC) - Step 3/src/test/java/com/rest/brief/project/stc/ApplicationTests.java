//package com.rest.brief.project.stc;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.rest.brief.project.stc.repository.*;
//import com.rest.brief.project.stc.service.*;
//
//@SpringBootTest
//class ApplicationTests {
//
//	@Autowired
//	 private UserRepository userRepository;
//	 
//	 @Autowired
//	 private UserService userService;
//	
//	 @Autowired
//	 private AdministrateurRepository adminRepository;
//	 
//	 @Autowired
//	 private AdministrateurService adminService;
//	 
//	 @Autowired
//	 private ActiviteRepository activityRepository;
//	 
//	 @Autowired
//	 private ActiviteService activityService;
//    
//	 @Autowired
//    private ResponsableRepository managerRepository;
//	 
//	 @Autowired
//	 private ResponsableService managerService;
//    
//	 @Autowired
//    private ExerciceRepository exerciseRepository;
//	 
//	 @Autowired
//	 private ExerciceService exerciseService;
//	 
//	 @Autowired
//	 private ParticipantRepository participantRepository;
//	 
//	 @Autowired
//	 private ParticipantService participantService;
//	
//	   
//		  @Test
//		  void testCreateUser(){
//		  User user =new User();
//		  
//		  user.setName("Mohamedd");
//		  user.setEmail("med@testing.ma");
//		  user.setEnabled(true);
//		  user.setMale(true);
//		  user.setPassword("passordd");
//		  user.setRole();
//		  user.setTel("0703000000"); 
//		  user.setUserName("dewssq");
//		  userRepository.save(user);
//		  }
//		  
//	       /*
//		  @Test
//		  void getAllUsers() {
//			    List<User>list = userRepository.findAll();
//				assertThat(list).size().isGreaterThan(0);
//		  }
//		  */
//	      /*
//		  @Test 
//			void TestDeleteUser() {
//			  userService.delete(7L);
//			}
//		   */
//	        /*
//		  @Test  
//			void TestUpdateUser() {
//				User user = new User();
//			    user = userRepository.findUserById(7L); 
//				user.setUserName("med");
//				userRepository.save(user);
//			}
//		  
//		  */
//			/*
//			 * @Test void TestCreateAdmin() { Admin admin = new Admin(); admin.setId(12L);
//			 * admin.setLevel("Frontend"); adminRepository.save(admin); }
//			 */
//	       
//			/*
//			 * @Test void TestUpdateAdmin() { Admin admin = new Admin(); admin =
//			 * adminRepository.findAdminById(9L); admin.setLevel("Senior");
//			 * adminRepository.save(admin);
//			 * 
//			 * }
//			 */
//			/*
//			 * @Test void TestDeleteAmin() { adminService.delete(11L); }
//			 */
//	         
//		  
//          
//			/*
//			 * @Test void TestCreateActivity() { Activity activity = new Activity();
//			 * activity.setId(2L); activity.setName("Java EE");
//			 * activity.setDescription("it's Platforme ... ");
//			 * activity.setType("Trainning"); activity.setEnabled(true); LocalDate dt1
//			 * =LocalDate.parse("2021-02-12"); activity.setStartedAt(dt1);
//			 * activity.setEndedAt(dt1); activityRepository.save(activity); }
//			 */
//	     
//			/*
//			 * @Test void TestUpdateActivity() { Activity activity = new Activity();
//			 * activity = activityRepository.findActivityById(1L);
//			 * activity.setName("jakarta EE"); activity.setType("Event ! ! !");
//			 * activityRepository.save(activity); }
//			 */
//       
//	     /*
//	     @Test 
//	     void TestDeleteActivity() {
//	    	 activityService.delete(2L);
//	     }
//	     */
//	 /*
//	 @Test
//	 void TestCreateManager() {
//		 Manager manager = new Manager();
//		 manager.setId(20L);
//		 manager.setDomain("Frontend");
//		 manager.setType("speaker");
//		 managerRepository.save(manager);
//		 
//	 }
//	 */
//	 /*
//	 @Test
//	 void TestUpdateManager() {
//		 Manager manager = new Manager();
//		 manager = managerRepository.findManagerById(16L);
//		 manager.setDomain("trainnner");
//		 managerRepository.save(manager);
//	 }
//	 
//	 @Test
//	 void TestDeleteManager() {
//		 managerService.delete(14L);
//	 }
//	 */
//	 /*
//	 @Test 
//	 void TestCreateExercise() {
//		 Exercise exercise =new Exercise();
//		 exercise.setId(3L);
//		 exercise.setEnabled(true);
//		 LocalDate dt1 =LocalDate.parse("2021-02-12"); 
//		 exercise.setStartedAt(dt1);
//		 LocalDate dt2 =LocalDate.parse("2021-02-12"); 
//		 exercise.setEndedAt(dt2);
//		 exercise.setName("Java Exerciseeeeeeeee");
//		 exerciseRepository.save(exercise);
//		
//	 }
//	 */
//	 /*
//	 @Test
//	 void TestUpdateExercise() {
//	    Exercise exercise =new Exercise();
//	    exercise = exerciseRepository.findExerciseById(1L);
//	    exercise.setName("PostgreSQL Exercise");
//	    exerciseRepository.save(exercise);
//	    
//	 }
//	 */
//	 /*
//	 @Test
//	 void TestDeleteExercise() {
//		 exerciseService.delete(2L);
//	 }
//	*/
//	 /*
//	 @Test
//	 void TestCreateParticipant() {
//		 Participant participante = new Participant();
//		 participante.setId(18L);
//		 participante.setDomain("Backeend");
//		 participantRepository.save(participante);
//	 }
//	 
//	 @Test
//	 void TestUpdateParticipant() {
//		 Participant participant = new Participant();
//		 participant = participantRepository.findParticipantById(17L);
//		 participant.setDomain("Frontendddddd");
//		 participantRepository.save(participant);
//	 }
//	 */
//	 /*
//	 @Test
//	 void TestDeleteParticpant() {
//		 participantService.delete(17L);
//	 }
//	*/
//
//}
