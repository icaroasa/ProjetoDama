
package projetodamas2;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;


public class JogoDama extends JFrame implements ActionListener{
    private JButton[][] tabuleiro = new JButton[8][8];
    private Campo[][] campo = new Campo[8][8];
    private boolean vez = true;
    private int linhaAnterior = 0;
    private int alterado = 0;
    private int colunaAnterior = 0;
    private Map <JButton,String> indice = new HashMap<>();
    private ImageIcon qps = new ImageIcon(getClass().getResource("/image/qps.jpg"));
    private ImageIcon qp = new ImageIcon(getClass().getResource("/image/qp.png"));
    private ImageIcon qb = new ImageIcon(getClass().getResource("/image/qb.png"));
    private ImageIcon pecaverde = new ImageIcon(getClass().getResource("/image/pg.png"));
    private ImageIcon pecavermelha = new ImageIcon(getClass().getResource("/image/pr.png"));
    private ImageIcon pecaverdes = new ImageIcon(getClass().getResource("/image/pgs.jpg"));
    private ImageIcon pecavermelhas = new ImageIcon(getClass().getResource("/image/prs.jpg"));
    private ImageIcon pecaverded = new ImageIcon(getClass().getResource("/image/pgd.png"));
    private ImageIcon pecavermelhad = new ImageIcon(getClass().getResource("/image/prd.png"));
    private ImageIcon pecaverdeds = new ImageIcon(getClass().getResource("/image/pgds.jpg"));
    private ImageIcon pecavermelhads = new ImageIcon(getClass().getResource("/image/prds.jpg"));
    
    public JogoDama() {
       this.configurarFrame();
       this.criarTabuleiro();
       this.colocarPedras();
    }
    
    private void configurarFrame(){
        this.setTitle("Jogo da Velha");
        this.setLayout(new GridLayout(8,8));
        this.setSize(new Dimension(600,600));
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    private ImageIcon scaleImage(ImageIcon image, JButton l){
            
            ImageIcon icon = image;
            Image img = icon.getImage();
            Image imgScale = img.getScaledInstance(l.getWidth(),l.getHeight(),Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(imgScale);
            
            return scaledIcon;
    }
    private void colocarPedras(){
        for(int i = 0;i<tabuleiro.length;i++){
            for(int j = 0;j <tabuleiro[0].length;j++){
                if(i<3){
                    if(i%2==0){
                            if(j%2!=0){
                                this.tabuleiro[i][j].setIcon(scaleImage(this.pecaverde,this.tabuleiro[i][j]));
                                this.campo[i][j].setPedraVerdeB(true);
                            }
                    }else{
                            if(j%2==0){
                                this.tabuleiro[i][j].setIcon(scaleImage(this.pecaverde,this.tabuleiro[i][j]));
                                this.campo[i][j].setPedraVerdeB(true);
                            }
                        }
                }else if(i>4 && i<8){
                    if(i%2==0){
                            if(j%2!=0){
                                this.tabuleiro[i][j].setIcon(scaleImage(this.pecavermelha,this.tabuleiro[i][j]));
                                this.campo[i][j].setPedraVermelhaB(true);
                            }
                    }else{
                            if(j%2==0){
                                this.tabuleiro[i][j].setIcon(scaleImage(this.pecavermelha,this.tabuleiro[i][j]));
                                this.campo[i][j].setPedraVermelhaB(true);
                            }
                        }
                    }
            }
        }
    }
    private void criarTabuleiro(){
        for(int i = 0;i<tabuleiro.length;i++){
            for(int j = 0;j <tabuleiro[0].length;j++){
                this.tabuleiro[i][j]= new JButton();
                this.indice.put(this.tabuleiro[i][j],i+""+j+"");
                this.tabuleiro[i][j].setSize(75,75);
                this.tabuleiro[i][j].addActionListener(this);
                this.campo[i][j]=new Campo();
                this.add(this.tabuleiro[i][j]);
                if(i%2==0){
                    if(j%2==0){
                        this.tabuleiro[i][j].setIcon(scaleImage(this.qb,this.tabuleiro[i][j]));
                    }else{
                        this.tabuleiro[i][j].setIcon(scaleImage(this.qp,this.tabuleiro[i][j]));
                    }
                }else{
                    if(j%2==0){
                        this.tabuleiro[i][j].setIcon(scaleImage(this.qp,this.tabuleiro[i][j]));
                    }else{
                        this.tabuleiro[i][j].setIcon(scaleImage(this.qb,this.tabuleiro[i][j]));
                    }
                }
            }
        }
    }
    private int linha(String linha){
        int var = Character.getNumericValue(linha.charAt(0));
        return var;
    }
    private int coluna(String coluna){
        int var = Character.getNumericValue(coluna.charAt(1));
        return var;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String var = this.indice.get(e.getSource());
        int linha = linha(var);
        int coluna = coluna(var);
        boolean verifica;
        boolean verifica1;
        boolean verificaAnterior;
        boolean verificaAnterior1;
        boolean verificaObjeto;
        boolean verificaObjeto1;
        boolean verificaObjetoAn;
        boolean verificaObjetoAn1;
    /*  //Vazios
        //-------------------------------------------------------------------
        try{
                if(vez){
                    verifica = this.campo[linha+1][coluna-1].isVazio();
                }else{
                    verifica = this.campo[linha-1][coluna-1].isVazio();
                }
                
           }
        catch(java.lang.ArrayIndexOutOfBoundsException a){
                   verifica = false;
           }
        //-------------------------------------------------------------------
        try{
                if(vez){
                    verifica1 = this.campo[linha+1][coluna+1].isVazio();
                }else{
                    verifica1 = this.campo[linha-1][coluna+1].isVazio();
                }
           }
        catch(java.lang.ArrayIndexOutOfBoundsException a){
                   verifica1 = false;
            }
        //Objetos
        //-------------------------------------------------------------------
        try{
                if(vez){
                    verificaObjeto = this.campo[linha+1][coluna-1].isPedraVermelha();
                }else{
                    verificaObjeto = this.campo[linha-1][coluna-1].isPedraVerde();
                }
                
           }
        catch(java.lang.ArrayIndexOutOfBoundsException a){
                   verificaObjeto = false;
           }
        //-------------------------------------------------------------------
        try{
                if(vez){
                    verificaObjeto1 = this.campo[linha+1][coluna+1].isPedraVermelha();
                }else{
                    verificaObjeto1 = this.campo[linha-1][coluna+1].isPedraVerde();
                }
           }
        catch(java.lang.ArrayIndexOutOfBoundsException a){
                   verificaObjeto1 = false;
            }
        //Vazio Anterior
        //-------------------------------------------------------------------
        try{
                if(vez){
                   verificaAnterior = this.campo[linhaAnterior+1][colunaAnterior-1].isVazio();
                }else{
                    verificaAnterior = this.campo[linhaAnterior-1][colunaAnterior-1].isVazio();
                }
           }
        catch(java.lang.ArrayIndexOutOfBoundsException a){
                   verificaAnterior = false;
           }
        //-------------------------------------------------------------------
        try{
                if(vez){
                   verificaAnterior1 = this.campo[linhaAnterior+1][colunaAnterior+1].isVazio();
                }else{
                    verificaAnterior1 = this.campo[linhaAnterior-1][colunaAnterior+1].isVazio();
                }
           }
        catch(java.lang.ArrayIndexOutOfBoundsException a){
                   verificaAnterior1 = false;
           }
        //Objeto Anterior
        //-------------------------------------------------------------------
        try{
                if(vez){
                   verificaObjetoAn = this.campo[linhaAnterior+1][colunaAnterior-1].isPedraVermelha();
                }else{
                   verificaObjetoAn = this.campo[linhaAnterior-1][colunaAnterior-1].isPedraVerde();
                }
           }
        catch(java.lang.ArrayIndexOutOfBoundsException a){
                   verificaObjetoAn = false;
           }
        //-------------------------------------------------------------------
        try{
                if(vez){
                   verificaObjetoAn1 = this.campo[linhaAnterior+1][colunaAnterior+1].isPedraVermelha();
                }else{
                    verificaObjetoAn1 = this.campo[linhaAnterior-1][colunaAnterior+1].isPedraVerde();
                }
           }
        catch(java.lang.ArrayIndexOutOfBoundsException a){
                   verificaObjetoAn1 = false;
           }*/
        //-------------------------------------------------------------------
        //-------------------------------------------------------------------
        //-------------------------------------------------------------------
        //-------------------------------------------------------------------
        
        if(vez){
            //Movendo
            if(alterado == 1){
                
            }
            if(this.campo[linha][coluna].isPedraVerde() && vez){
               //Repitando deafault
               if(alterado ==1){
                    this.tabuleiro[linhaAnterior][colunaAnterior].setIcon(scaleImage(pecaverde,this.tabuleiro[linhaAnterior][colunaAnterior]));
                    pintarArea(linhaAnterior,colunaAnterior,qp);
               }
               this.alterado = 1;
               
               //Pitando possiveis areas
               this.tabuleiro[linha][coluna].setIcon(scaleImage(pecaverdes,this.tabuleiro[linha][coluna]));
               pintarArea(linha,coluna,qps);
               this.linhaAnterior = linha;
               this.colunaAnterior = coluna;
            }
            
        }else{
            //Movendo
            
            if(this.campo[linha][coluna].isPedraVermelha() && !vez){
               //Repitando deafault
            }
        }
    }
    private void pintarArea(int linha,int coluna,ImageIcon image){
        boolean verifica;
        boolean verificaObjeto;
        for(int j = (coluna-1);j<coluna+2 ;j+=2){
                   for(int i =(linha-1);i<(linha+2);i+=2){
                       //------------------------------------------------------------------
                       try{
                           verifica = this.campo[i][j].isVazio();
                       }catch(java.lang.ArrayIndexOutOfBoundsException a){
                           verifica = false;
                       }
                       //------------------------------------------------------------------
                       try{
                           if(vez){
                                verificaObjeto = this.campo[i][j].isPedraVermelha();
                           }else{
                                verificaObjeto = this.campo[i][j].isPedraVerde();
                           }
                       }catch(java.lang.ArrayIndexOutOfBoundsException a){
                           verificaObjeto = false;
                       }
                       //------------------------------------------------------------------
                       if(verifica && (i>linha) && this.campo[linha][coluna].isPedraVerde()){
                           this.tabuleiro[i][j].setIcon(scaleImage(image,this.tabuleiro[i][j]));
                       }else if(verifica && (i<linha) && this.campo[linha][coluna].isPedraVermelha()){
                           this.tabuleiro[i][j].setIcon(scaleImage(image,this.tabuleiro[i][j]));
                       }else if(verificaObjeto){
                           if(i>linha){
                               if(j>coluna){
                                   try{
                                       verifica = this.campo[i+1][j+1].isVazio();
                                   }catch(java.lang.ArrayIndexOutOfBoundsException a){
                                       verifica = false;
                                   }
                                   if(verifica){
                                        this.tabuleiro[i+1][j+1].setIcon(scaleImage(image,this.tabuleiro[i+1][j+1]));
                                        this.pintarArea((i+1),(j+1),qps);
                                   }
                               }else{
                                   try{
                                       verifica = this.campo[i+1][j-1].isVazio();
                                   }catch(java.lang.ArrayIndexOutOfBoundsException a){
                                       verifica = false;
                                   }
                                   if(verifica){
                                        this.tabuleiro[i+1][j-1].setIcon(scaleImage(image,this.tabuleiro[i+1][j-1]));
                                        this.pintarArea((i+1),(j-1),qps);
                                   }
                               }
                           }else if(i<linha){
                               if(j>coluna){
                                   try{
                                       verifica = this.campo[i-1][j+1].isVazio();
                                   }catch(java.lang.ArrayIndexOutOfBoundsException a){
                                       verifica = false;
                                   }
                                   if(verifica){
                                        this.tabuleiro[i-1][j+1].setIcon(scaleImage(image,this.tabuleiro[i-1][j+1]));
                                        this.pintarArea((i-1),(j+1),qps);
                                   }
                               }else{
                                   try{
                                       verifica = this.campo[i-1][j-1].isVazio();
                                   }catch(java.lang.ArrayIndexOutOfBoundsException a){
                                       verifica = false;
                                   }
                                   if(verifica){
                                        this.tabuleiro[i-1][j-1].setIcon(scaleImage(image,this.tabuleiro[i-1][j-1]));
                                        this.pintarArea((i-1),(j-1),qps);
                                   }
                               }
                           }else{
                               break;
                           }
                       }
                       
                   }
               }
    }
    private void mover(int linha, int coluna,ImageIcon image){
        
        boolean verifica;
        boolean verificaObjeto;
        for(int j = (colunaAnterior-1);j<colunaAnterior+2 ;j+=2){
                   for(int i =(linhaAnterior-1);i<(linhaAnterior+2);i+=2){
                       //------------------------------------------------------------------
                       try{
                           verifica = (this.campo[i][j].isVazio()&& i == linha && j == coluna);
                       }catch(java.lang.ArrayIndexOutOfBoundsException a){
                           verifica = false;
                       }
                       //------------------------------------------------------------------
                       try{
                           if(vez){
                                verificaObjeto = this.campo[i][j].isPedraVermelha();
                           }else{
                                verificaObjeto = this.campo[i][j].isPedraVerde();
                           }
                       }catch(java.lang.ArrayIndexOutOfBoundsException a){
                           verificaObjeto = false;
                       }
                       //------------------------------------------------------------------
                       if(verifica &&(i>linhaAnterior)&& this.campo[linhaAnterior][colunaAnterior].isPedraVerde()){
                           this.campo[linhaAnterior][colunaAnterior].setVazio(true);
                           this.campo[i][j].setPedraVerdeB(true);
                           this.tabuleiro[i][j].setIcon(scaleImage(image,this.tabuleiro[i][j]));
                           
                       }else if(verifica && (i<linhaAnterior) && this.campo[linhaAnterior][colunaAnterior].isPedraVermelha()){
                           this.campo[linhaAnterior][colunaAnterior].setVazio(true);
                           this.campo[i][j].setPedraVermelhaB(true);
                           this.tabuleiro[i][j].setIcon(scaleImage(image,this.tabuleiro[i][j]));
                           
                       }else if(verificaObjeto){
                           if(i>linha){
                               if(j>coluna){
                                   try{
                                       verifica = this.campo[i+1][j+1].isVazio();
                                   }catch(java.lang.ArrayIndexOutOfBoundsException a){
                                       verifica = false;
                                   }
                                   if(verifica){
                                        this.tabuleiro[i+1][j+1].setIcon(scaleImage(image,this.tabuleiro[i+1][j+1]));
                                        this.pintarArea((i+1),(j+1),qps);
                                   }
                               }else{
                                   try{
                                       verifica = this.campo[i+1][j-1].isVazio();
                                   }catch(java.lang.ArrayIndexOutOfBoundsException a){
                                       verifica = false;
                                   }
                                   if(verifica){
                                        this.tabuleiro[i+1][j-1].setIcon(scaleImage(image,this.tabuleiro[i+1][j-1]));
                                        this.pintarArea((i+1),(j-1),qps);
                                   }
                               }
                           }else if(i<linha){
                               if(j>coluna){
                                   try{
                                       verifica = this.campo[i-1][j+1].isVazio();
                                   }catch(java.lang.ArrayIndexOutOfBoundsException a){
                                       verifica = false;
                                   }
                                   if(verifica){
                                        this.tabuleiro[i-1][j+1].setIcon(scaleImage(image,this.tabuleiro[i-1][j+1]));
                                        this.pintarArea((i-1),(j+1),qps);
                                   }
                               }else{
                                   try{
                                       verifica = this.campo[i-1][j-1].isVazio();
                                   }catch(java.lang.ArrayIndexOutOfBoundsException a){
                                       verifica = false;
                                   }
                                   if(verifica){
                                        this.tabuleiro[i-1][j-1].setIcon(scaleImage(image,this.tabuleiro[i-1][j-1]));
                                        this.pintarArea((i-1),(j-1),qps);
                                   }
                               }
                           }else{
                               break;
                           }
                       }
                       
                   }
               }
    }
    
}
