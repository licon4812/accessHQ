using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.Support.UI;

namespace AccessHQ.NETTestProject
{
    

    [TestClass]
    public class PlanetTestSuite
    {
        private ChromeDriver? driver;

        [TestInitialize]
        public void Setup()
        {
            driver = new ChromeDriver();
            driver.Manage().Window.FullScreen();
            driver.Url = "https://d18u5zoaatmpxx.cloudfront.net/index.html#/";
            var nav = new Nav(driver);
            nav.NavigateToPlanets();
        }

        [TestMethod]
        public void TestEarthExplore()
        {
            foreach (WebElement currentElement in driver.FindElements(By.ClassName("planet")))
            {
                if (currentElement.FindElement(By.ClassName("name")).Text == "Earth")
                {
                    currentElement.FindElement(By.TagName("button")).Click();
                }
            }

            var popup = driver.FindElement(By.ClassName("popup-message"));
            new WebDriverWait(driver, new TimeSpan(1)).Until(d => d.FindElement
                (By.ClassName("popup-message")).Displayed);
            Assert.AreEqual(expected:"Exploring Earth", actual: popup.Text);
        }

        [TestCleanup]
        public void Cleanup()
        {
            driver?.Quit();
        }
    }
}