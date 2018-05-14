package DBContext;

import java.io.IOException;
import java.util.Set;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Account.Account;
import model.ModelUser;
import model.UserProfileModel;
import model.WorkDefinitionModel;
import DAL.USERPROFILE;
import DAL.USERROLE;
import DAL.WORKDEFINITION;
import DAL.CONTROLLER;
import DAL.PROCESS;
import DAL.PROCESSORDER;
import DAL.PROCESSSTEP;
import DAL.ROLE;
import DAL.ROLECONTROLLER;
import DAL.ROLEPROCESS;
import DAL.USER;
@WebServlet("/DataBase")
public class DataBase extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public DataBase() {
        super();
      }
@SuppressWarnings("unchecked")
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//response.getWriter().append("Served at: ").append(request.getContextPath());
	USER user=new USER();
	CONTROLLER con=new CONTROLLER();
	PROCESS prcess=new PROCESS();
	PROCESSORDER usroleorder=new PROCESSORDER();
	PROCESSSTEP prstp =new PROCESSSTEP();
	ROLE rl=new ROLE();
	ROLECONTROLLER rlcon=new ROLECONTROLLER();
	ROLEPROCESS rlprocess=new ROLEPROCESS();
	USERPROFILE usrprf=new USERPROFILE();
	USERROLE usrole=new USERROLE();
	WORKDEFINITION wrk=new WORKDEFINITION();
	
 String [] prm=request.getParameter("actions").split(",");
 String controller=prm[0];
 String action=prm[1];
 //System.out.println(request.getParameter("ProcessCheck").toString());
	try {	
	switch (controller.toLowerCase()) { 
     case "user": if(action.equals("create")) {  user.Create(user.modeldoldur(request));
     													}else {  if(action.equals("edit")) {user.Edit(user.modeldoldur(request)); 
     													  } else { if(action.equals("delete")) { user.Delete(user.modeldoldur(request));
     																																	}
     																									}
     														  }   
              break;
     case "controller": if(action.equals("create")) {  con.Create(con.modeldoldur(request));
		}else {  if(action.equals("edit")) {con.Edit(con.modeldoldur(request)); 
		  } else { if(action.equals("delete")) { con.Delete(con.modeldoldur(request));
																						}
														}
			  }   ;
              break;
     case "process":  if(action.equals("create")) {  prcess.Create(prcess.modeldoldur(request));
		}else {  if(action.equals("edit")) {prcess.Edit(prcess.modeldoldur(request)); 
		  } else { if(action.equals("delete")) { prcess.Delete(prcess.modeldoldur(request));
																						}
														}
			  }   ;
              break;
     case "processorder":   if(action.equals("create")) { usroleorder.Create(usroleorder.modeldoldur(request));
		}else {  if(action.equals("edit")) {usroleorder.Edit(usroleorder.modeldoldur(request)); 
		  } else { if(action.equals("delete")) { usroleorder.Delete(usroleorder.modeldoldur(request));
																						}
														}
			  }   ;
              break;
     case "processstep":  if(action.equals("create")) {  prstp.Create(prstp.modeldoldur(request));
		}else {  if(action.equals("edit")) {prstp.Edit(prstp.modeldoldur(request)); 
		  } else { if(action.equals("delete")) { prstp.Delete(prstp.modeldoldur(request));
																						}
														}
			  }   ;
              break;
     case "role":  if(action.equals("create")) {  rl.Create(rl.modeldoldur(request));
		}else {  if(action.equals("edit")) {rl.Edit(rl.modeldoldur(request)); 
		  } else { if(action.equals("delete")) { rl.Delete(rl.modeldoldur(request));
																						}
														}
			  }   ;
              break;
     case "rolecontroller":   if(action.equals("create")) {  rlcon.Create(rlcon.modeldoldur(request));
		}else {  if(action.equals("edit")) {rlcon.Edit(rlcon.modeldoldur(request)); 
		  } else { if(action.equals("delete")) { rlcon.Delete(rlcon.modeldoldur(request));
																						}
														}
			  }   ;
              break;
     case "roleprocess":   if(action.equals("create")) {  rlprocess.Create(rlprocess.modeldoldur(request));
		}else {  if(action.equals("edit")) {rlprocess.Edit(rlprocess.modeldoldur(request)); 
		  } else { if(action.equals("delete")) { rlprocess.Delete(rlprocess.modeldoldur(request));
																						}
														}
			  }   ;
              break;
     case "userprofile":   if(action.equals("create")) {  usrprf.Create(usrprf.modeldoldur(request));
		}else {  if(action.equals("edit")) {usrprf.Edit(usrprf.modeldoldur(request)); 
		  } else { if(action.equals("delete")) { usrprf.Delete(usrprf.modeldoldur(request));
																						}
														}
			  }   ;
              break;
     case "userrole":  if(action.equals("create")) {  usrole.Create(usrole.modeldoldur(request));
		}else {  if(action.equals("edit")) {usrole.Edit(usrole.modeldoldur(request)); 
		  } else { if(action.equals("delete")) { usrole.Delete(usrole.modeldoldur(request));
																						}
														}
			  }   ;
              break;
     case "workdefinition":  if(action.equals("create")) {  wrk.Create(wrk.modeldoldur(request));
		}else {  if(action.equals("edit")) {wrk.Edit(wrk.modeldoldur(request)); 
		  } else { if(action.equals("delete")) { wrk.Delete(wrk.modeldoldur(request));
																						}
														}
			  }   ;
                          break;
     case "planning":  if(action.equals("create")) {  
    	 
    	 String prn=request.getParameter("planingData");
    	 
    	 System.out.println(prn);
    	// String[] yndata=(String[])request.getParameter("planningData2").split(",");
    	 
    	// planingCreate(prn, yndata);
		
     
     
     }else {  if(action.equals("edit")) {wrk.Edit(wrk.modeldoldur(request)); 
		  } 
			  }   ;
                       break;
     }
	
	
   response.sendRedirect("/processManagement/"+controller+"/");
		
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	

	
		 /*	try {
		
			
			wrk=wr.modeldoldur(request);
			System.out.println(wrk.getWorkDefinitionName());
			int dc=wr.Create(wrk);
			System.out.println(wrk);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
	/*	try {
			for(UserProfileModel s:prf.GetUserProfileListId("surname","corakli"," and phone='111'"))
			{
				System.out.println(s.getUserId()+" "+s.getUserProfileId()+" "+s.getName()+" "+s.getSurName()+" "+s.getPhone()+" "+s.getMail()+" "+s.getAddress());
				prf1.setUserProfileId(s.getUserProfileId());
				prf1.setAddress(s.getAddress().toString());
				prf1.setMail(s.getMail().toString());
				prf1.setName("Hami");
				prf1.setPhone(s.getPhone().toString());
				prf1.setSurName(s.getSurName().toString());
				prf1.setUserId(s.getUserId());
			}	
			
			a=prf.Edit(prf1);
			
			for(UserProfileModel s1:prf.GetUserProfileList())
			{
				System.out.println(s1.getUserId()+" "+s1.getUserProfileId()+" "+s1.getName()+" "+s1.getSurName()+" "+s1.getPhone()+" "+s1.getMail()+" "+s1.getAddress());
				
			}	
			
				} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
			     }

public void planingCreate ( String [][] pr, String[] ynData) throws ClassNotFoundException, SQLException
{
	CRUD cr=new CRUD();
	String[][] ata = null;
	String[][] ata1 = null;
	String[] prm=new String[] {"ProcessId","WorkdefinitionId","PlanDate","PlanEndDate","UserId","Satatus"};
	String[] prms=new String[] {"PlanningId","ProcessId","WorkdefinitionId","PlanDate","PlanEndDate","UserId","Satatus"};
 int k=0;
int t=0;
	for(int j=0;j<pr.length;j++) {
		if(ynData.toString().contains(pr[j][0])) {
			String a=((String [])((ArrayList)(cr.Query( "Select WorkDefinitionId from workdefinition where WorkDefinitionName="+pr[j][1].toString().split("/")[0].toString()))).get(0))[0];
		ata[t]= new String[] {pr[j][0],a,pr[j][2],pr[j][3],pr[j][4],"0"};
		t++;
	}else {
		String a=((String [])((ArrayList)(cr.Query( "Select WorkDefinitionId from workdefinition where WorkDefinitionName="+pr[j][1].toString().split("/")[0].toString()))).get(0))[0];
		ata[k]= new String[] {pr[j][0],a,pr[j][2],pr[j][3],pr[j][4],"0"}; k++;
	}}
		for(int i=0;i<ata.length;i++) {
		int a=cr.Create(prm,ata[i],"planning");
		}
	
	
}

@SuppressWarnings("unchecked")
public ArrayList<String[]> planingList ( ) throws ClassNotFoundException, SQLException
{
	CRUD cr=new CRUD();
	String[] prm=new String[] {"PlanId","ProcessId","WorkdefinitionId","PlanDate","PlanEndDate","UserId","Status"};
	
	
	return (ArrayList)cr.Query("Select PlanId,ProcessId,WorkdefinitionId,PlanDate,PlanEndDate from planning where Status !=1"); 
}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}