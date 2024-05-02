
import Model.GameModel;
import View.GameView;
import Controller.GameController;

public class Main {
    public static void main(String[] args) {
        GameModel model = new GameModel();
        GameView view = new GameView();
        GameController controller = new GameController(model, view);

        // Optionally, start the view or make it visible within the main or through the controller
        //view.setVisible(true);
    }
}