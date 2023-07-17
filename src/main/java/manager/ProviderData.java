package manager;

import model.User;
import org.testng.annotations.*;
import java.util.*;


public class ProviderData{
    @DataProvider
    public Iterator<Object[]> userLoginPositiveDto(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{new User()
                .withEmail("domes7@mail.com")
                .withPassword("123456Aa$")
            }
        );
        list.add(new Object[]{new User()
                .withEmail("domes287@mail.com")
                .withPassword("123456Aa$")
            }
        ); 
		list.add(new Object[]{new User()
                .withEmail("domes529@mail.com")
                .withPassword("123456Aa$")
            }
        );	
		list.add(new Object[]{new User()
                .withEmail("domes123@mail.com")
                .withPassword("123456Aa$")
            }
        );
		
        return list.iterator();
    }

@DataProvider
    public Iterator<Object[]> userDtoNegReg(){
        List<Object[]> list = new ArrayList<>();
            list.add(new Object[]{new User()
                            .withEmail("domesmail.com")
                            .withPassword("123456Aa$")
                    }
            );
            list.add(new Object[]{new User()
                            .withEmail("domes77777@mailcom")
                            .withPassword("123456Aa$")
                    }
            );
			list.add(new Object[]{new User()
                            .withEmail("domes77777@mailcom")
                            .withPassword("1234561a$")
                    }
            );
            list.add(new Object[]{new User()
                            .withEmail("domes77777@mail.com")
                            .withPassword("12345678Aa")
                    }
            );
            list.add(new Object[]{new User()
                            .withEmail("domes77777@mail.com")
                            .withPassword("12345678A$")
                    }
            );
            list.add(new Object[]{new User()
                            .withEmail("domes77777@mail.com")
                            .withPassword("1Aa$")
                    }							
            );
			 return list.iterator();
    }
			
}