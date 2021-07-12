
package projetodamas2;


public class Campo {
    private boolean vazio;
    private PedraVerde pedraVerde = new PedraVerde();
    private PedraVermelha pedraVermelha = new PedraVermelha();
    private DamaVerde damaVerde = new DamaVerde();
    private DamaVermelha damaVermelha = new DamaVermelha();
    public Campo() {
        setVazio(true);
    }

    
    
    public boolean isPedraVerde() {
        return this.pedraVerde.isExiste();
    }

    public void setPedraVerdeB(boolean pedraVerde) {
        this.pedraVerde.setExiste(pedraVerde);
        if(pedraVerde){
            this.vazio = false;
            this.pedraVermelha.setExiste(false);
            this.damaVermelha.setExiste(false);
            this.damaVerde.setExiste(false);
        }
    }

    public boolean isPedraVermelha() {
        return this.pedraVermelha.isExiste();
    }

    public void setPedraVermelhaB(boolean pedraVermelha) {
        this.pedraVermelha.setExiste(pedraVermelha);
         if(pedraVermelha){
            this.vazio = false;
            this.pedraVerde.setExiste(false);
            this.damaVermelha.setExiste(false);
            this.damaVerde.setExiste(false);
        }
    }
    public boolean isDamaVerde() {
        return this.damaVerde.isExiste();
    }

    public void setDamaVerdeB(boolean damaVerde) {
        this.damaVerde.setExiste(damaVerde);
         if(damaVerde){
            this.vazio = false;
            this.damaVermelha.setExiste(false);
            this.pedraVermelha.setExiste(false);
            this.pedraVerde.setExiste(false);
        }
    }
    public boolean isDamaVermelha() {
        return this.damaVermelha.isExiste();
    }

    public void setDamaVermelhaB(boolean damaVermelha) {
        this.damaVermelha.setExiste(damaVermelha);
         if(damaVermelha){
            this.vazio = false;
            this.damaVerde.setExiste(false);
            this.pedraVermelha.setExiste(false);
            this.pedraVerde.setExiste(false);
        }
    }
    public boolean isVazio() {
        return vazio;
    }

    public void setVazio(boolean vazio) {
        this.vazio = vazio;
        if(vazio){
            this.pedraVerde.setExiste(false);
            this.pedraVermelha.setExiste(false);
            this.damaVerde.setExiste(false);
            this.damaVermelha.setExiste(false);
        }
    }
}
