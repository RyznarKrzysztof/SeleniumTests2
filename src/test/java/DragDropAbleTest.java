import org.testng.annotations.Test;

public class DragDropAbleTest extends BaseTest{


    @Test
    public void dragDropAbleTest(){

        SideMenu sideMenu = new SideMenu(driver);
        DroppablePage droppablePage = new DroppablePage(driver);

        sideMenu.clickDroppableFromSideMenu();

        droppablePage.switchToFrame()
                     .moveDragableToDropable()
                     .assertDragableInDropable();

    }

}
