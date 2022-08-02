package view;

import controller.FractalGenerator;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.*;
import model.Plan;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class LiveView extends Application {

    //public static void main(String[] args) {
//Application.launch(Main.class, args);
    //}
    //Stage primaryStage;
    int maxIteration = 250;
    double zoom = 2;
    double xDisplayRatio = 1.25;
    double yDisplayRatio = 1;
    double aMin = -2;
    double aMax = 2;
    double bMin = -2;
    double bMax = 2;
    int viewWidth = 400;
    int viewHeight = 300;
    double stepX =(aMax-aMin)/viewWidth;
    double stepY =(bMax-bMin)/viewHeight;
    double im = 0.;
    double re = 0.;
    boolean f_set = true;
    int[] colors = new int[252];
    WritableImage img = new WritableImage(viewWidth+1, viewHeight+1);



    int stageWidth () {return (int) (viewWidth*xDisplayRatio);}
    int stageHeight (){return (int) (viewHeight*yDisplayRatio);}



    @Override
    public void start(Stage primaryStage) {
        System.out.println(stepX);
        System.out.println(stepY);
        //this.primaryStage = primaryStage;
        primaryStage.setMinWidth(stageWidth());
        primaryStage.setMinHeight(stageHeight());
        primaryStage.setTitle("Fractal Generator");
        Group root = new Group();
        Scene scene = new Scene(root, stageWidth(), stageHeight(), Color.DARKGREY);
        StackPane viewPane = new StackPane();
        //viewPane.setMinWidth(400);
        ImageView iview = new ImageView(img);
        viewPane.getChildren().add(iview);
        GridPane gridPane = new GridPane();
        //control
        GridPane controlPane = new GridPane();
        controlPane.setVgap(10);
        controlPane.setHgap(5);
        //controlPane.setMinWidth(300);
        //StackPane controlPane = new StackPane();
        //viewPane.setPrefSize(viewWidth,viewHeight);
        controlPane.setPrefSize(stageWidth()-viewWidth,stageHeight());
        controlPane.setAlignment(Pos.TOP_CENTER);

        //controlPane.getChildren().add(new Rectangle(100.,100., Color.valueOf("#ed4b00")));
        Label choose_algorithm = new Label();
        //choose_algorithm.setFont(new Font(14));
        choose_algorithm.setText("Choose set please");
        choose_algorithm.setMinWidth(Region.USE_PREF_SIZE);
        controlPane.add(choose_algorithm, 0, 0);
        RadioButton choose_algorithm_button_j = new RadioButton();
        choose_algorithm_button_j.setText("Julia");
        controlPane.add(choose_algorithm_button_j, 0, 1);
        RadioButton choose_algorithm_button_m = new RadioButton();
        choose_algorithm_button_m.setText("Mandelbrot");
        ToggleGroup choose_set = new ToggleGroup();
        choose_algorithm_button_j.setToggleGroup(choose_set);
        choose_algorithm_button_m.setToggleGroup(choose_set);
        controlPane.add(choose_algorithm_button_m, 0, 2);
        //Label choose_polynomial_degree = new Label();
        //choose_polynomial_degree.setFont(new Font(14));
        //choose_polynomial_degree.setText("Choose polynomial degree please");
       // choose_polynomial_degree.setMinWidth(Region.USE_PREF_SIZE);
        //controlPane.add(choose_polynomial_degree, 1, 4);
        //MenuButton choose_polynomial_degree_button = new MenuButton("Choose polynomial degree please");
        //choose_polynomial_degree_button.getItems().addAll(new MenuItem(" 1"), new MenuItem(" 2"));
        //controlPane.add(choose_polynomial_degree_button, 1, 5);
        //controlPane.add(new Label("Image width"), 0, 6);
        //controlPane.add(new Label("Image height"), 1, 6);
        TextField width = new TextField();
        TextField height = new TextField();
        TextField text_zoom = new TextField();
        TextField c_re = new TextField();
        TextField c_im = new TextField();
        width.setMinWidth(100.);
        width.setMaxWidth(100.);
        height.setMinWidth(100.);
        height.setMaxWidth(100.);
        text_zoom.setMinWidth(100.);
        text_zoom.setMaxWidth(100.);
        width.setPromptText("Image width");
        height.setPromptText("Image height");
        text_zoom.setPromptText("choose zoom between 1 and 9");
        c_re.setPromptText("starting real complex part");
        c_im.setPromptText("starting imaginary complex part");
        controlPane.add(width, 0, 5);
        controlPane.add(height, 1, 5);
        controlPane.add(text_zoom, 0, 6);
        controlPane.add(c_re, 0, 7);
        controlPane.add(c_im, 1, 7);

        Button submit = new Button("Submit");

        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                gridPane.getChildren().remove(viewPane);
                gridPane.add(viewPane, 0,0);
                viewWidth = Integer.parseInt(width.getText());
                viewHeight = Integer.parseInt(height.getText());
                im = Double.parseDouble(c_im.getText());
                re = Double.parseDouble(c_re.getText());
                stepX =(aMax-aMin)/viewWidth;
                stepY =(bMax-bMin)/viewHeight;
                RadioButton selectedRadioButton = (RadioButton) choose_set.getSelectedToggle();
                if (selectedRadioButton.equals(choose_algorithm_button_m)){
                    f_set = false;
                }
                else
                {
                    f_set = true;
                }
                viewPane.setMinSize((double)viewWidth,(double)viewHeight);
                zoom = Integer.parseInt(text_zoom.getText());
                primaryStage.setMinHeight(stageHeight());
                primaryStage.setMinWidth(stageWidth());

                //viewPane.setPrefSize(viewWidth,viewHeight);
                img.cancel();
                //viewPane.getChildren().clear();
                img = new WritableImage(viewWidth+1, viewHeight+1);
                //ImageView iview = new ImageView(img);
                iview.setImage(img);
                iview.resize(Integer.parseInt(width.getText()), Integer.parseInt(height.getText()));
                //viewPane.getChildren().add(iview);
                primaryStage.close();
                primaryStage.show();

                try {
                    //refresh(aMin, aMax, bMin, bMax,stepX/zoom, stepY/zoom, 0.01);
                    refresh(aMin, aMax,bMin, bMax,stepX, stepY, im, re, f_set);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
            });

        controlPane.add(submit, 0, 9);


        //gridPane.setMinSize(400, 400);
        //gridPane.setPadding(new Insets(0, 10, 10, 10));
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.add(controlPane, 1,0);

        root.getChildren().add(gridPane);

        primaryStage.setScene(scene);
        primaryStage.show();

        for (int c = 0; c<maxIteration+2; c++){
            int j =  c;
            colors[c]= j*10 << 16 | j*5 << 8 | j*2;
        }

        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                try {
                    refresh(aMin, aMax, bMin, bMax,stepX, stepY, im, re, f_set);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                System.out.println("A key was pressed");
            }
        });
        iview.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println(event.getSceneX());
                System.out.println(event.getSceneY());

                //System.out.println("ivew w = "+viewWidth+" ivew h= "+viewHeight);
                double xRange = aMax-aMin;
                double yRange = bMax-bMin;
                double xShift = event.getSceneX()/viewWidth;
                double yShift = event.getSceneY()/viewHeight;
                double aClicked = aMin+xShift*xRange;
                double bClicked = bMax-yShift*yRange;
                double newAMin = aClicked-(xShift*xRange/zoom);
                double newBMax = bClicked+(yShift*yRange/zoom);
                double newAMax = newAMin+xRange/zoom;
                double newBMin = newBMax-yRange/zoom;
                try {
                    refresh(newAMin, newAMax, newBMin, newBMax,stepX/zoom, stepY/zoom, im, re, f_set);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });


    }

    public void refresh(double aMin, double aMax, double bMin, double bMax, double stepX, double stepY, double im, double re, boolean f_set) throws Exception{
        System.out.println(aMin);
        System.out.println(aMax);
        System.out.println(bMin);
        System.out.println(bMax);
        /*this.aMin = aMin;
        this.aMax = aMax;
        this.bMin = bMin;
        this.bMax = bMax;
        this.stepX = stepX;
        this.stepY = stepY;*/
        int x = 0;
        int y = 0;
        Plan plan = new Plan(aMin,aMax,bMin,bMax);
        FractalGenerator fractal = new FractalGenerator(plan, maxIteration);
        if(f_set) {
            for (double a = aMin; a <= aMax; a = a + stepX) {
                for (double b = bMax; b >= bMin; b = b - stepY) {
                    int value = fractal.divergenceJulia(new Complex(a, b), new Complex(re, im), fractal.getMaxIteration());
                    double hue = Color.GREEN.getHue() / 4 + (Color.RED.getHue() * 10 + Color.BLUE.getHue() * 10) * value / fractal.getMaxIteration();
                    Color color = Color.hsb(hue, 1.0, 1.0);
                    this.img.getPixelWriter().setColor(x, y, color);
                    y++;
                }
                x++;
                y = 0;
            }
        }
        else
        {
            for (double a = aMin; a <= aMax; a = a + stepX) {
                for (double b = bMax; b >= bMin; b = b - stepY) {
                    int value = fractal.divergenceMandelbrot( new Complex(re, im), new Complex(a, b), fractal.getMaxIteration());
                    double hue = Color.GREEN.getHue() / 4 + (Color.RED.getHue() * 10 + Color.BLUE.getHue() * 10) * value / fractal.getMaxIteration();
                    Color color = Color.hsb(hue, 1.0, 1.0);
                    this.img.getPixelWriter().setColor(x, y, color);
                    y++;
                }
                x++;
                y = 0;
            }
        }

    }

    public static void main(String[] args ) {
        Scanner scan = new Scanner(System.in);
        System.out.println("1 to run graphical choice, 2 textual one ");
        if (scan.nextInt() == 2) {
            System.out.println("enter image width please ");
            int width = scan.nextInt();
            System.out.println("enter image height please ");
            int height = scan.nextInt();
           // System.out.println("enter image zoom please ");

            //int zoom = scan.nextInt();

            boolean f_set;
            System.out.println("1 Julia, 2 Mandelbrot ");
            if (scan.nextInt() == 1) {
                f_set = true;
            }
            else{
                f_set =false;
            }
            System.out.println("enter real part of complex number please ");
            String input = scan.next();
            double re = Double.parseDouble(input);
            System.out.println("enter imaginary  part of complex number please ");
            input = scan.next();
            double im = Double.parseDouble(input);
            try {
                PngGenerator.createPng((-2), 2, (-2), 2, width, height, im, re, f_set);
            }catch (Exception e1) {
                e1.printStackTrace();
            }
            System.out.println("set.png has been created, thank you. ");

        }else {
            launch(args);
        }

        System.exit(0);
    }
}