//Coded By ~Hritvik~
import java.lang.Math;
import java.util.Scanner;
import java.io.*;
class Snake_Game_By_Hritvik
{
    static String player_name,high_player_name;
    static int i,j,head_row,head_col,flag_desc,high_score,moves,least_moves;
    static int size=2,flag1=0,fruit_eat=0;
    static boolean game_over=true;
    static Scanner scan = new Scanner(System.in);
    static char arr[][] = new char[25][35];
    static int arr_snk_row[] = new int[500];
    static int arr_snk_col[] = new int[500];
    public static void cls()                                                                 //Used For Clearing Screen
    {   
	    try
        {	
		    new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
        }
        catch(Exception E)
		{
			System.out.println(E);
		}
    }
    public static void getname()                                                            //Used To Get Player Name
    {
        System.out.print("\n\tEnter Player Name: ");
        player_name = scan.nextLine();
        System.out.println();
    }
    static void default_board_layout()                                                  //Used For Printing Default/Fixed Walls,etc
    {
        for(i=0;i<25;i++)
        {
            for(j=0;j<35;j++)
            {
                arr[i][j] = ' ';
            }
        }
        for(i=0;i<25;i++)
        {
            arr[i][0] = '|';
            arr[i][34] = '|';
        }
        for(j=0;j<35;j++)
        {
            arr[0][j] = '-';
            arr[24][j] = '-';
        }
    }
    static void default_walls()                                                     //Default Walls In Game
    {
        arr[3][5] = 'W';
        arr[4][5] = 'W';
        arr[5][5] = 'W';
        arr[6][5] = 'W';
        arr[7][5] = 'W';
        arr[8][5] = 'W';
        arr[8][3] = 'W';
        arr[8][4] = 'W';
        arr[8][5] = 'W';
        arr[8][6] = 'W';
        arr[8][7] = 'W';
        arr[21][16] = 'W';
        arr[21][17] = 'W';
        arr[21][18] = 'W';
        arr[21][19] = 'W';
        arr[21][20] = 'W';
        arr[21][21] = 'W';
        arr[21][22] = 'W';
        arr[21][23] = 'W';
        arr[21][24] = 'W';
        arr[21][25] = 'W';
        arr[21][26] = 'W';
        arr[21][27] = 'W';
        arr[21][28] = 'W';
        arr[21][29] = 'W';
        arr[21][30] = 'W';
        arr[16][16] = 'W';
        arr[17][16] = 'W';
        arr[18][16] = 'W';
        arr[19][16] = 'W';
        arr[20][16] = 'W';
        arr[21][16] = 'W';
        arr[16][30] = 'W';
        arr[17][30] = 'W';
        arr[18][30] = 'W';
        arr[19][30] = 'W';
        arr[20][30] = 'W';
        arr[21][30] = 'W';
        arr[16][17] = 'W';
        arr[16][18] = 'W';
        arr[16][19] = 'W';
        arr[16][27] = 'W';
        arr[16][28] = 'W';
        arr[16][29] = 'W';
        arr[2][27] = 'W';
        arr[3][27] = 'W';
        arr[4][27] = 'W';
        arr[5][27] = 'W';
        arr[6][27] = 'W';
        arr[7][27] = 'W';
        arr[8][27] = 'W';
        arr[8][28] = 'W';
        arr[8][29] = 'W';
        arr[8][30] = 'W';
        arr[8][31] = 'W';
        arr[14][1] = 'W';
        arr[14][2] = 'W';
        arr[14][3] = 'W';
        arr[14][4] = 'W';
        arr[14][5] = 'W';
        arr[14][6] = 'W';
        arr[14][7] = 'W';
        arr[18][10] = 'W';
        arr[18][11] = 'W';
        arr[18][12] = 'W';
        arr[18][13] = 'W';
        arr[18][14] = 'W';
        arr[18][15] = 'W';
        arr[21][1] = 'W';
        arr[21][2] = 'W';
        arr[21][3] = 'W';
        arr[21][4] = 'W';
        arr[21][5] = 'W';
        arr[21][6] = 'W';
        arr[2][18] = 'W';
        arr[2][19] = 'W';
        arr[2][20] = 'W';
        arr[2][21] = 'W';
        arr[2][22] = 'W';
        arr[3][23] = 'W';
        arr[4][23] = 'W';
        arr[5][23] = 'W';
        arr[6][23] = 'W';
        arr[7][23] = 'W';
        arr[8][23] = 'W';
        arr[2][23] = 'W';
        arr[9][23] = 'W';
        arr[10][23] = 'W';
        arr[11][15] = 'W';
        arr[11][16] = 'W';
        arr[11][17] = 'W';
        arr[11][18] = 'W';
        arr[11][19] = 'W';
        arr[11][20] = 'W';
        arr[11][21] = 'W';
        arr[11][22] = 'W';
        arr[11][23] = 'W';
        arr[11][14] = 'W';
        arr[11][13] = 'W';
        arr[11][12] = 'W';
        arr[6][11] = 'W';
        arr[6][12] = 'W';
        arr[6][13] = 'W';
        arr[6][14] = 'W';
        arr[6][10] = 'W';
        arr[6][15] = 'W';
        arr[6][16] = 'W';
        arr[7][13] = 'W';
        arr[8][13] = 'W';
    }
    static int random1()                                                        //Used To Generate Random Number From 1 To 23
    {
        int range,min,max,rand;
        min = 1;
        max = 23;
        range = max-min+1;
        rand = (int)(Math.random()*range)+min;
        return rand;
    }
    static int random2()                                                        //Used To Generate Random Number From 1 To 33
    {
        int range,min,max,rand;
        min = 1;
        max = 33;
        range = max-min+1;
        rand = (int)(Math.random()*range)+min;
        return rand;
    }
    static void fruits_display()                                            //Used To Display Fruits In Game Randomly
    {
        int ind1,ind2;
        char x;
        ind1 = random1();
        ind2 = random2();
        x = arr[ind1][ind2];
        if(x==' ')
        {
            arr[ind1][ind2] = '@';
        }
        else
        {
            fruits_display();
        }
    }
    public static void instructions()                                   //Used To Display Game Instructions At Startup
    {
        System.out.println ("\n\n");
        System.out.println ("     *************************************************************************************************************************************************************\n");
        System.out.println ("\t\t\t\t\t\t\t\t   Welcome To Snake Game");
        System.out.println ("\t\t\t\t\t\t\t\t     ~By Hritvik Maini\n\n");
        System.out.println ("\t\t\t\t\t\t\t\t\tInstructions:");
        System.out.println ("\t\t\t\t\t\tThis Program Is A Regular Snake Game. There Are 4 Movement Keys For Snake:");
        System.out.println ();
        System.out.println ("\t\t\t\t\t\t\t\t\t  W - Up");
        System.out.println ("\t\t\t\t\t\t\t\t\t  S - Down");
        System.out.println ("\t\t\t\t\t\t\t\t\t  D - Right");
        System.out.println ("\t\t\t\t\t\t\t\t\t  A - Left");
        System.out.println ("\t\t\t\t\t\t\t\t\t  Q - Quit Game");
        System.out.println ();
        System.out.println ("\t\t\t\t\t\t\t  Snake Length Will Be Increased By 1 After Eating Fruit.");
        System.out.println ("\t\t\t\t\t      If Player Strikes On Wall Or At Boundary Or Strikes To Itself Then Game Is Over.");
        System.out.println ("\t\t\t\tTotal Score Will Be Stored With Player Name And Score Will Be Updated When New Score Is Greater Than Prevoius One.");
        System.out.println ("\t\t\t\t\t\t\t\t\tSo, Let's PLAY!!!\n");
    }
    public static void board_display()                                  //Used To Display Current State Of Game
    {
        System.out.println ("     -------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.print("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   High Score: " + high_score + " With " + least_moves + " Moves");
        if(high_player_name==" ")
        {
            System.out.println();
        }
        else
        {
            System.out.print(" By " + high_player_name + "\n");
        }
        for(i=0;i<25;i++)
        {
            System.out.print("\t\t\t\t\t          ");
            for(j=0;j<35;j++)
            {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void snake_init()                                         //Used To Initialize Snake In Game At Startup
    {
        int rand_1,rand_2;
        rand_1 = random1();
        rand_2 = random2();
        if(arr[rand_1][rand_2]==' ' && arr[rand_1][rand_2+1]==' ' && arr[rand_1][rand_2+2]==' ' && arr[rand_1][rand_2+3]==' ')
        {
            arr[rand_1][rand_2+2] = 'O';
            arr[rand_1][rand_2+1] = 'x';
            arr[rand_1][rand_2] = 'x';
            head_row = rand_1;
            head_col = rand_2+2;
            arr_snk_row[0] = rand_1;
            arr_snk_col[0] = rand_2+1;
            arr_snk_row[1] = rand_1;
            arr_snk_col[1] = rand_2;
        }
        else if (arr[rand_1][rand_2]==' ' && arr[rand_1][rand_2-1]==' ' && arr[rand_1][rand_2-2]==' ' && arr[rand_1][rand_2-3]==' ')
        {
            arr[rand_1][rand_2-2] = 'O';
            arr[rand_1][rand_2-1] = 'x';
            arr[rand_1][rand_2] = 'x';
            head_row = rand_1;
            head_col = rand_2-2;
            arr_snk_row[0] = rand_1;
            arr_snk_col[0] = rand_2-1;
            arr_snk_row[1] = rand_1;
            arr_snk_col[1] = rand_2;
        }
        else if (arr[rand_1][rand_2]==' ' && arr[rand_1+1][rand_2]==' ' && arr[rand_1+2][rand_2]==' ' && arr[rand_1+3][rand_2]==' ')
        {
            arr[rand_1+2][rand_2] = 'O';
            arr[rand_1+1][rand_2] = 'x';
            arr[rand_1][rand_2] = 'x';
            head_row = rand_1+2;
            head_col = rand_2;
            arr_snk_row[0] = rand_1+1;
            arr_snk_col[0] = rand_2;
            arr_snk_row[1] = rand_1;
            arr_snk_col[1] = rand_2;
        }
        else if (arr[rand_1][rand_2]==' ' && arr[rand_1-1][rand_2]==' ' && arr[rand_1-2][rand_2]==' ' && arr[rand_1-3][rand_2]==' ')
        {
            arr[rand_1-2][rand_2] = 'O';
            arr[rand_1-1][rand_2] = 'x';
            arr[rand_1][rand_2] = 'x';
            head_row = rand_1-2;
            head_col = rand_2;
            arr_snk_row[0] = rand_1-1;
            arr_snk_col[0] = rand_2;
            arr_snk_row[1] = rand_1;
            arr_snk_col[1] = rand_2;
        }
        else
        {
            snake_init();
        }
    }
    public static void input_user()                                 //Used To Get Input For Movement Of Snake
    {
        int inp;
        System.out.print("\n\tEnter Your Choise: ");
        try
        {
            inp = scan.nextLine().charAt(0);
            System.out.println ("\n     ----------------------------------------------------");
            switch(inp)
            {
                case 'a':
                case 'A':
                {
                    flag_desc = 1;
                    break;
                }
                case 'w':
                case 'W':
                {
                    flag_desc = 2;
                    break;
                }
                case 's':
                case 'S':
                {
                    flag_desc = 3;
                    break;
                }
                case 'd':
                case 'D':
                {
                    flag_desc = 4;
                    break;
                }
                case 'q':
                case 'Q':
                {
                    game_over = false;
                    break;
                }
                default:
                {
                    cls();
                    board_display();
                    System.out.println ("     ----------------------------------------------------\n");
                    System.out.println("\tTotal Fruits Eaten By Snake Is: "+fruit_eat);
                    System.out.println("\n\tInvalid Input, Try Again!!");
                    input_user();
                }
            }
        }
        catch(Exception e)
        {
            cls();
            board_display();
            System.out.println ("     ----------------------------------------------------\n");
            System.out.println("\tTotal Fruits Eaten By Snake Is: "+fruit_eat);
            System.out.println("\n\tNO INPUT, TRY AGAIN!!");
            input_user();
        }
    }
    public static void snk_move()                                       //This Function Is BRAIN Of Game, Used For Movement Of Snake On Board
    {
        int temp_row,temp_col,temp_var1,temp_var2;
        switch(flag_desc)
        {
            case 1:
            {
                cls();
                if(arr[head_row][head_col-1]=='x')
                {
                    board_display();
                    System.out.println ("\n\t\t\t\t\t\t      ********************************************************\n");
                    System.out.println("\t\t\t\t\t\t\t\t   OOPS SNAKE CAN'T EAT ITSELF!!!!");
                    System.out.println("\n\t\t\t\t\t\t\t\t\t   GAME OVER!!!!");
                    System.out.println("\n\t\t\t\t\t\t\t\t\t  TOTAL SCORE: "+fruit_eat);
                    System.out.println ("\n\t\t\t\t\t\t      ********************************************************\n");
                    System.out.print("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tSnake Game v0.76");
                    System.out.print("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tCoded By: ~Hritvik Maini");
                    System.out.print("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tSubmitted To: Manik Sir (CU-HP)");
                    System.out.print("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tLanguage Used: JAVA (JDK v13.0.1)");
                    System.out.print("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tEditor Used: VS Code v1.42");
                    game_over=false;
                    break;
                }
                if(arr[head_row][head_col-1]=='@')
                {
                    moves++;
                    fruit_eat++;
                    fruits_display();
                    arr[head_row][head_col-1] = arr[head_row][head_col];
                    temp_row = head_row;
                    temp_col = head_col; 
                    for(i=0;i<size;i++)
                    {
                        arr[temp_row][temp_col] = arr[arr_snk_row[i]][arr_snk_col[i]];
                        temp_var1 = temp_row;
                        temp_var2 = temp_col;
                        temp_row = arr_snk_row[i];
                        temp_col = arr_snk_col[i];
                        arr_snk_row[i] = temp_var1;
                        arr_snk_col[i] = temp_var2;
                    }
                    arr[temp_row][temp_col] = 'x';
                    size++;
                    arr_snk_row[size-1] = temp_row;
                    arr_snk_col[size-1] = temp_col;
                    head_col = head_col-1;
                    break;
                }
                else
                {
                    moves++;
                    arr[head_row][head_col-1] = arr[head_row][head_col];
                    temp_row = head_row;
                    temp_col = head_col;
                    for(i=0;i<size;i++)
                    {
                        arr[temp_row][temp_col] = arr[arr_snk_row[i]][arr_snk_col[i]];
                        temp_var1 = temp_row;
                        temp_var2 = temp_col;
                        temp_row = arr_snk_row[i];
                        temp_col = arr_snk_col[i];
                        arr_snk_row[i] = temp_var1;
                        arr_snk_col[i] = temp_var2;
                    }
                    arr[temp_row][temp_col] = ' ';
                    head_col = head_col-1;
                    break;
                }
            }
            case 2:
            {
                cls();
                if(arr[head_row-1][head_col]=='x')
                {
                    board_display();
                    System.out.println ("\n\t\t\t\t\t\t      ********************************************************\n");
                    System.out.println("\t\t\t\t\t\t\t\t   OOPS SNAKE CAN'T EAT ITSELF!!!!");
                    System.out.println("\n\t\t\t\t\t\t\t\t\t   GAME OVER!!!!");
                    System.out.println("\n\t\t\t\t\t\t\t\t\t  TOTAL SCORE: "+fruit_eat);
                    System.out.println ("\n\t\t\t\t\t\t      ********************************************************\n");
                    System.out.print("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tSnake Game v0.76");
                    System.out.print("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tCoded By: ~Hritvik Maini");
                    System.out.print("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tSubmitted To: Manik Sir (CU-HP)");
                    System.out.print("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tLanguage Used: JAVA (JDK v13.0.1)");
                    System.out.print("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tEditor Used: VS Code v1.42");
                    game_over=false;
                    break;
                }
                if(arr[head_row-1][head_col]=='@')
                {
                    moves++;
                    fruit_eat++;
                    fruits_display();
                    arr[head_row-1][head_col] = arr[head_row][head_col];
                    temp_row = head_row;
                    temp_col = head_col;
                    for(i=0;i<size;i++)
                    {
                        arr[temp_row][temp_col] = arr[arr_snk_row[i]][arr_snk_col[i]];
                        temp_var1 = temp_row;
                        temp_var2 = temp_col;
                        temp_row = arr_snk_row[i];
                        temp_col = arr_snk_col[i];
                        arr_snk_row[i] = temp_var1;
                        arr_snk_col[i] = temp_var2;
                    }
                    arr[temp_row][temp_col] = 'x';
                    size++;
                    arr_snk_row[size-1] = temp_row;
                    arr_snk_col[size-1] = temp_col;
                    head_row = head_row-1;
                    break;
                }
                else
                {
                    moves++;
                    arr[head_row-1][head_col] = arr[head_row][head_col];
                    temp_row = head_row;
                    temp_col = head_col;
                    for(i=0;i<size;i++)
                    {
                        arr[temp_row][temp_col] = arr[arr_snk_row[i]][arr_snk_col[i]];
                        temp_var1 = temp_row;
                        temp_var2 = temp_col;
                        temp_row = arr_snk_row[i];
                        temp_col = arr_snk_col[i];
                        arr_snk_row[i] = temp_var1;
                        arr_snk_col[i] = temp_var2;
                    }
                    arr[temp_row][temp_col] = ' ';
                    head_row = head_row-1;
                    break;
                }
            }
            case 3:
            {
                cls();
                if( arr[head_row+1][head_col]=='x')
                {
                    board_display();
                    System.out.println ("\n\t\t\t\t\t\t      ********************************************************\n");
                    System.out.println("\t\t\t\t\t\t\t\t   OOPS SNAKE CAN'T EAT ITSELF!!!!");
                    System.out.println("\n\t\t\t\t\t\t\t\t\t   GAME OVER!!!!");
                    System.out.println("\n\t\t\t\t\t\t\t\t\t  TOTAL SCORE: "+fruit_eat);
                    System.out.println ("\n\t\t\t\t\t\t      ********************************************************\n");
                    System.out.print("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tSnake Game v0.76");
                    System.out.print("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tCoded By: ~Hritvik Maini");
                    System.out.print("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tSubmitted To: Manik Sir (CU-HP)");
                    System.out.print("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tLanguage Used: JAVA (JDK v13.0.1)");
                    System.out.print("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tEditor Used: VS Code v1.42");
                    game_over=false;
                    break;
                }
                if(arr[head_row+1][head_col]=='@')
                {
                    moves++;
                    fruit_eat++;
                    fruits_display();
                    arr[head_row+1][head_col] = arr[head_row][head_col];
                    temp_row = head_row;
                    temp_col = head_col;
                    for(i=0;i<size;i++)
                    {
                        arr[temp_row][temp_col] = arr[arr_snk_row[i]][arr_snk_col[i]];
                        temp_var1 = temp_row;
                        temp_var2 = temp_col;
                        temp_row = arr_snk_row[i];
                        temp_col = arr_snk_col[i];
                        arr_snk_row[i] = temp_var1;
                        arr_snk_col[i] = temp_var2;
                    }
                    arr[temp_row][temp_col] = 'x';
                    size++;
                    arr_snk_row[size-1] = temp_row;
                    arr_snk_col[size-1] = temp_col;
                    head_row = head_row+1;
                    break;
                }
                else
                {
                    moves++;
                    arr[head_row+1][head_col] = arr[head_row][head_col];
                    temp_row = head_row;
                    temp_col = head_col;
                    for(i=0;i<size;i++)
                    {
                        arr[temp_row][temp_col] = arr[arr_snk_row[i]][arr_snk_col[i]];
                        temp_var1 = temp_row;
                        temp_var2 = temp_col;
                        temp_row = arr_snk_row[i];
                        temp_col = arr_snk_col[i];
                        arr_snk_row[i] = temp_var1;
                        arr_snk_col[i] = temp_var2;
                    }
                    arr[temp_row][temp_col] = ' ';
                    head_row = head_row+1;
                    break;
                }
            }
            case 4:
            {
                cls();
                if(arr[head_row][head_col+1]=='x')
                {
                    board_display();
                    System.out.println ("\n\t\t\t\t\t\t      ********************************************************\n");
                    System.out.println("\t\t\t\t\t\t\t\t   OOPS SNAKE CAN'T EAT ITSELF!!!!");
                    System.out.println("\n\t\t\t\t\t\t\t\t\t   GAME OVER!!!!");
                    System.out.println("\n\t\t\t\t\t\t\t\t\t  TOTAL SCORE: "+fruit_eat);
                    System.out.println ("\n\t\t\t\t\t\t      ********************************************************\n");
                    System.out.print("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tSnake Game v0.76");
                    System.out.print("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tCoded By: ~Hritvik Maini");
                    System.out.print("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tSubmitted To: Manik Sir (CU-HP)");
                    System.out.print("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tLanguage Used: JAVA (JDK v13.0.1)");
                    System.out.print("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tEditor Used: VS Code v1.42");
                    game_over=false;
                    break;
                }
                if(arr[head_row][head_col+1]=='@')
                {
                    moves++;
                    fruit_eat++;
                    fruits_display();
                    arr[head_row][head_col+1] = arr[head_row][head_col];
                    temp_row = head_row;
                    temp_col = head_col;
                    for(i=0;i<size;i++)
                    {
                        arr[temp_row][temp_col] = arr[arr_snk_row[i]][arr_snk_col[i]];
                        temp_var1 = temp_row;
                        temp_var2 = temp_col;
                        temp_row = arr_snk_row[i];
                        temp_col = arr_snk_col[i];
                        arr_snk_row[i] = temp_var1;
                        arr_snk_col[i] = temp_var2;
                    }
                    arr[temp_row][temp_col] = 'x';
                    size++;
                    arr_snk_row[size-1] = temp_row;
                    arr_snk_col[size-1] = temp_col;
                    head_col = head_col+1;
                    break;
                }
                else
                {
                    moves++;
                    arr[head_row][head_col+1] = arr[head_row][head_col];
                    temp_row = head_row;
                    temp_col = head_col;
                    for(i=0;i<size;i++)
                    {
                        arr[temp_row][temp_col] = arr[arr_snk_row[i]][arr_snk_col[i]];
                        temp_var1 = temp_row;
                        temp_var2 = temp_col;
                        temp_row = arr_snk_row[i];
                        temp_col = arr_snk_col[i];
                        arr_snk_row[i] = temp_var1;
                        arr_snk_col[i] = temp_var2;
                    }
                    arr[temp_row][temp_col] = ' ';
                    head_col = head_col+1;
                    break;
                }
            }
        }
    }
    public static void game_progress()                                  //Used For Calling Different Function & Check For Collision Of Snake In Game
    {
        while(game_over)
        {
            input_user();
            if(game_over==false)
            {
                System.out.println("\n\tQuitting Game.........");
                System.out.println ("\n\t\t\t\t\t\t      ********************************************************\n");
                System.out.println("\t\t\t\t\t\t\t\t\t  TOTAL SCORE: "+fruit_eat);
                System.out.println("\n\t\t\t\t\t\t\t\t      THANKS FOR PLAYING!!!!");
                System.out.println ("\n\t\t\t\t\t\t      ********************************************************\n");
                System.out.print("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tSnake Game v0.76");
                System.out.print("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tCoded By: ~Hritvik Maini");
                System.out.print("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tSubmitted To: Manik Sir (CU-HP)");
                System.out.print("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tLanguage Used: JAVA (JDK v13.0.1)");
                System.out.print("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tEditor Used: VS Code v1.42");
                break;
            }
            if(flag1!=1)
            {
                if(flag_desc==4)
                {
                    flag1 = 4;
                    if(arr[head_row][head_col+1]=='W' || arr[head_row][head_col+1]=='|' || arr[head_row][head_col+1]=='-')
                    {
                        System.out.println ("\n\t\t\t\t\t\t      ********************************************************\n");
                        if(arr[head_row][head_col+1]=='W')
                        {
                            System.out.println("\t\t\t\t\t\t\t\t  OOPS SNAKE CAN'T PASS THROUGH WALL!!!");
                        }
                        else
                        {
                            System.out.println("\t\t\t\t\t\t\t\t  OOPS SNAKE CAN'T PASS BOUNDARY!!!!");
                        }
                        System.out.println("\n\t\t\t\t\t\t\t\t\t   GAME OVER!!!!");
                        System.out.println("\n\t\t\t\t\t\t\t\t\t  TOTAL SCORE: "+fruit_eat);
                        System.out.println ("\n\t\t\t\t\t\t      ********************************************************\n");
                        System.out.print("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tSnake Game v0.76");
                        System.out.print("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tCoded By: ~Hritvik Maini");
                        System.out.print("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tSubmitted To: Manik Sir (CU-HP)");
                        System.out.print("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tLanguage Used: JAVA (JDK v13.0.1)");
                        System.out.print("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tEditor Used: VS Code v1.42");
                        break;
                    }
                    else
                    {
                        snk_move();
                        if(game_over==false)
                        {
                            break;
                        }
                        else
                        {
                            cls();
                            board_display();
                            System.out.println ("     ----------------------------------------------------");
                            System.out.println("\n\tTotal Fruits Eaten By Snake Is: "+fruit_eat);
                            System.out.println("\n\tTotal Moves: "+moves);
                        }
                    }
                }
            }
            else if(flag1==1 && flag_desc==4)
            {
                cls();
                board_display();
                System.out.println ("     ----------------------------------------------------");
                System.out.println("\n\tTotal Fruits Eaten By Snake Is: "+fruit_eat);
                System.out.println("\n\tINVALID MOVE, TRY AGAIN!!!");
            }
            if(flag1!=2)
            {
                if(flag_desc==3)
                {
                    flag1 = 3;
                    if(arr[head_row+1][head_col]=='W' || arr[head_row+1][head_col]=='|' || arr[head_row+1][head_col]=='-')
                    {
                        System.out.println ("\n\t\t\t\t\t\t      ********************************************************\n");
                        if(arr[head_row+1][head_col]=='W')
                        {
                            System.out.println("\t\t\t\t\t\t\t\t  OOPS SNAKE CAN'T PASS THROUGH WALL!!!");
                        }
                        else
                        {
                            System.out.println("\t\t\t\t\t\t\t\t  OOPS SNAKE CAN'T PASS BOUNDARY!!!!");
                        }
                        System.out.println("\n\t\t\t\t\t\t\t\t\t   GAME OVER!!!!");
                        System.out.println("\n\t\t\t\t\t\t\t\t\t  TOTAL SCORE: "+fruit_eat);
                        System.out.println ("\n\t\t\t\t\t\t      ********************************************************\n");
                        System.out.print("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tSnake Game v0.76");
                        System.out.print("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tCoded By: ~Hritvik Maini");
                        System.out.print("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tSubmitted To: Manik Sir (CU-HP)");
                        System.out.print("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tLanguage Used: JAVA (JDK v13.0.1)");
                        System.out.print("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tEditor Used: VS Code v1.42");
                        break;
                    }
                    else
                    {
                        snk_move();
                        if(game_over==false)
                        {
                            break;
                        }
                        else
                        {
                            cls();
                            board_display();
                            System.out.println ("     ----------------------------------------------------");
                            System.out.println("\n\tTotal Fruits Eaten By Snake Is: "+fruit_eat);
                            System.out.println("\n\tTotal Moves: "+moves);
                        }
                    }
                }
            }
            else if(flag1==2 && flag_desc==3)
            {
                cls();
                board_display();
                System.out.println ("     ----------------------------------------------------");
                System.out.println("\n\tTotal Fruits Eaten By Snake Is: "+fruit_eat);
                System.out.println("\n\tINVALID MOVE, TRY AGAIN!!!");
            }
            if(flag1!=3)
            {
                if(flag_desc==2)
                {
                    flag1 = 2;
                    if(arr[head_row-1][head_col]=='W' || arr[head_row-1][head_col]=='|' || arr[head_row-1][head_col]=='-')
                    {
                        System.out.println ("\n\t\t\t\t\t\t      ********************************************************\n");
                        if(arr[head_row-1][head_col]=='W')
                        {
                            System.out.println("\t\t\t\t\t\t\t\t  OOPS SNAKE CAN'T PASS THROUGH WALL!!!");
                        }
                        else
                        {
                            System.out.println("\t\t\t\t\t\t\t\t  OOPS SNAKE CAN'T PASS BOUNDARY!!!!");
                        }
                        System.out.println("\n\t\t\t\t\t\t\t\t\t   GAME OVER!!!!");
                        System.out.println("\n\t\t\t\t\t\t\t\t\t  TOTAL SCORE: "+fruit_eat);
                        System.out.println ("\n\t\t\t\t\t\t      ********************************************************\n");
                        System.out.print("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tSnake Game v0.76");
                        System.out.print("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tCoded By: ~Hritvik Maini");
                        System.out.print("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tSubmitted To: Manik Sir (CU-HP)");
                        System.out.print("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tLanguage Used: JAVA (JDK v13.0.1)");
                        System.out.print("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tEditor Used: VS Code v1.42");
                        break;
                    }
                    else
                    {
                        snk_move();
                        if(game_over==false)
                        {
                            break;
                        }
                        else
                        {
                            cls();
                            board_display();
                            System.out.println ("     ----------------------------------------------------");
                            System.out.println("\n\tTotal Fruits Eaten By Snake Is: "+fruit_eat);
                            System.out.println("\n\tTotal Moves: "+moves);
                        }
                    }
                }
            }
            else if(flag1==3 && flag_desc==2)
            {
                cls();
                board_display();
                System.out.println ("     ----------------------------------------------------");
                System.out.println("\n\tTotal Fruits Eaten By Snake Is: "+fruit_eat);
                System.out.println("\n\tINVALID MOVE, TRY AGAIN!!!");
            }
            if(flag1!=4)
            {
                if(flag_desc==1)
                {
                    flag1 = 1;
                    if(arr[head_row][head_col-1]=='W' || arr[head_row][head_col-1]=='|' || arr[head_row][head_col-1]=='-')
                    {
                        System.out.println ("\n\t\t\t\t\t\t      ********************************************************\n");
                        if(arr[head_row][head_col-1]=='W')
                        {
                            System.out.println("\t\t\t\t\t\t\t\t  OOPS SNAKE CAN'T PASS THROUGH WALL!!!");
                        }
                        else
                        {
                            System.out.println("\t\t\t\t\t\t\t\t  OOPS SNAKE CAN'T PASS BOUNDARY!!!!");
                        }
                        System.out.println("\n\t\t\t\t\t\t\t\t\t   GAME OVER!!!!");
                        System.out.println("\n\t\t\t\t\t\t\t\t\t  TOTAL SCORE: "+fruit_eat);
                        System.out.println ("\n\t\t\t\t\t\t      ********************************************************\n");
                        System.out.print("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tSnake Game v0.76");
                        System.out.print("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tCoded By: ~Hritvik Maini");
                        System.out.print("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tSubmitted To: Manik Sir (CU-HP)");
                        System.out.print("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tLanguage Used: JAVA (JDK v13.0.1)");
                        System.out.print("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tEditor Used: VS Code v1.42");
                        break;
                    }
                    else
                    {
                        snk_move();
                        if(game_over==false)
                        {
                            break;
                        }
                        else
                        {
                            cls();
                            board_display();
                            System.out.println ("     ----------------------------------------------------");
                            System.out.println("\n\tTotal Fruits Eaten By Snake Is: "+fruit_eat);
                            System.out.println("\n\tTotal Moves: "+moves);
                        }
                    }
                }
            }
            else if(flag1==4 && flag_desc==1)
            {
                cls();
                board_display();
                System.out.println ("     ----------------------------------------------------");
                System.out.println("\n\tTotal Fruits Eaten By Snake Is: "+fruit_eat);
                System.out.println("\n\tINVALID MOVE, TRY AGAIN!!!");
            }
        }
    }
    public static void main(String args[])                      //Main Func() Of Game, Used To Call Functions In Order & Storing Score And Moves In External Files
    {
        try
        {
            i=0;
            FileInputStream fin1 = new FileInputStream(".snake_high_score.dat");
            FileInputStream fin2 = new FileInputStream(".snake_least_moves.dat");
            BufferedReader bf1 = new BufferedReader(new FileReader("snake_player.dat"));
            high_score = fin1.read();
            least_moves = fin2.read();
            high_player_name = bf1.readLine();
            fin1.close();
            fin2.close();
            bf1.close();
        }
        catch(Exception e)
        {
            high_score = 0;
            least_moves = 0;
            high_player_name = " ";
        }    
        instructions();
        getname();
        default_board_layout();
        default_walls();
        for(i=4;i>=0;i--)
        {
            fruits_display();
        }
        snake_init();
        board_display();
        game_progress();
        try
        {
            FileOutputStream fout1 = new FileOutputStream(".snake_high_score.dat");              //.dat Extention Is Used To Encrypt Data So, That No User Can Open That File And Edit It...
            FileOutputStream fout2 = new FileOutputStream(".snake_least_moves.dat");            //Location Of File Is Also Not Defined For Security Purpose....
            FileWriter fw1 = new FileWriter("snake_player.dat",false);
            BufferedWriter bf1 = new BufferedWriter(fw1);
            if(fruit_eat>high_score)
            {
                fout1.write(fruit_eat);
                fout2.write(moves);
                bf1.write(player_name);
            }
            else
            {
                fout1.write(high_score);
                fout2.write(least_moves);
                bf1.write(high_player_name);
            }
            fout1.close();
            fout2.close();
            bf1.close();
        }
        catch(Exception e)
        {
            System.out.println("\n\t**********************************************\n");
            System.out.println("\t    I/O Error. Please Restart Game!!!");
            System.out.println("\n\t**********************************************\n");
        }
    }
}