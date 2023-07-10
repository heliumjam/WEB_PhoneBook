package manager;

import model.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class HelperContact extends HelperBase{

    public HelperContact(WebDriver wd) {
        super(wd);
    }
    public void openContactForm() {
        wd.findElement(By.xpath("//*[.='ADD']")).click();

    }
    public void fillContactForm(Contact contact) {
        type(By.xpath("//input[@placeholder='Name']"), contact.getName());
        type(By.xpath("//input[@placeholder='Last Name']"), contact.getLastName());
        type(By.xpath("//input[@placeholder='Phone']"), contact.getPhone());
        type(By.xpath("//input[@placeholder='email']"), contact.getEmail());
        type(By.xpath("//input[@placeholder='Address']"), contact.getAddress());
        type(By.xpath("//input[@placeholder='description']"), contact.getDescription());
    }

    public void submitContactForm() {
        click(By.xpath("//button[.='Save']"));
    }

    public boolean isContactCreated(Contact contact) {
       String phone =  wd.findElement(By.xpath("//div[@class='contact-item_card__2SOIM'][last()]//h3")).getText();
        return phone.equals(contact.getPhone());
    }

    public boolean asseptAlertWrongDataAddContact() {
        boolean bool=false;
        String alertText = wd.switchTo().alert().getText();
        System.out.println(alertText);
        if(alertText.contains("not valid")) bool = true;
        wd.switchTo().alert().accept();
        //return alertText.contains("not valid");
        return bool;
    }

    public String findAndSelectLastContactCreated(){
        String lastPhone = wd.findElement(By.xpath("//div[@class='contact-item_card__2SOIM'][last()]//h3")).getText();
        wd.findElement(By.xpath("//div[@class='contact-item_card__2SOIM'][last()]//h3")).click();
        return lastPhone;
    }
    public void asseptAlertbuttonOk() {
        wd.switchTo().alert().accept();
    }

    public void submitRemoveButton() {
        click(By.xpath("//button[.='Remove']"));
    }

    public boolean isContactDeleted(String phone){

        try {
            wd.findElement(By.xpath("//div[@class='contact-item_card__2SOIM']//h3[.='" + phone + "']"));
            System.out.println("Element Present");
            return false;
        }
        catch (NoSuchElementException e) {
            System.out.println("Element absent");
            return true;
        }

    }
    public void tst(String phone){
        wd.findElement(By.xpath("//div[@class='contact-item_card__2SOIM']//h3[.='"+phone+"']"));
    }

    public int removeOneContactLesson13(){
        int countBefore = countContacts();
        logger.info("Amount of contacts before is " + countBefore);
        click(By.xpath("//div[@class='contact-item_card__2SOIM']"));
        click(By.xpath("//button[.='Remove']"));
        pause(1000);
        int countAfter = countContacts();
        logger.info("Amount of contacts after is " + countAfter);
        return countBefore - countAfter;
    }

       public int countContacts(){
        int count = wd.findElements(By.xpath("//div[@class='contact-item_card__2SOIM']")).size();
        return count;

       }

    public void removeAllContacts(){
    while (wd.findElements(By.xpath("//div[@class='contact-item_card__2SOIM']")).size() > 0)
        removeOneContactLesson13();
    }

public boolean isNoContacts(){
    return wd.findElements(By.xpath("//div[@class='contact-item_card__2SOIM']")).size() == 0;
}
}
