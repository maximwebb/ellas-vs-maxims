public abstract class GameObject {

    int posX;
    int posY;

    GameObject(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }
    
    abstract void onUpdate();
}
