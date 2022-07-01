using OpenQA.Selenium;

namespace AccessHQ.NETTestProject.Models
{
    internal class Nav
    {
        private WebDriver driver;

        public Nav(WebDriver driver)
        {
            this.driver = driver;
        }

        public void NavigateToPlanets()
        {
            driver.FindElement(By.CssSelector("a[href='#/planets']")).Click();
        }
    }
}
