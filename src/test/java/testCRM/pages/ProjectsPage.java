package testCRM.pages;

import org.openqa.selenium.By;

import static keywords.WebUI.getURLPage;
import static keywords.WebUI.verifyContain;

public class ProjectsPage {
    private String subdirProjects = "/admin/projects";
    private String totalResult = "//div[@id='projects_info']";

    private By newProject = By.xpath("//a[normalize-space()='New Project']");
    private By InProgress = By.xpath("(//div[normalize-space()='Projects Summary']/following-sibling::div)//div//span[normalize-space()='In Progress']");
    private By inputSearch = By.xpath("//input[@class='form-control input-sm']");
    private By projectName = By.xpath("//input[@id='name']");
    private By customer = By.xpath("//input[@id='name']");
    private By dropdownBillingType = By.xpath("//select[@id='billing_type']");
    private By startDate = By.xpath("//input[@id='start_date']");
    private By checkboxProgress = By.xpath("//input[@id='progress_from_tasks']");
    private By progressBar = By.xpath("//span[@class='ui-slider-handle ui-corner-all ui-state-default']");
    private By buttonSave = By.xpath("//input[@id='start_date']");



    public ProjectsPage verifyProjectsPage(){
        verifyContain(getURLPage(), subdirProjects, "URL not True");
        return new ProjectsPage();
    }
}
