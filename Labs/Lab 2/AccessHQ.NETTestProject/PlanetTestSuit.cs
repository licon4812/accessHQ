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
            var planetPage = new PlanetPage(driver);
            planetPage.clickExplore();
            planetPage.waitForPopUp();
            var popup = planetPage.getPopUpElement(); 
            Assert.AreEqual(expected:"Exploring Earth", actual: popup.Text);
        }

        [TestCleanup]
        public void Cleanup()
        {
            driver?.Quit();
        }
    }
}