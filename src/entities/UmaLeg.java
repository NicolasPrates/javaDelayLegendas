package entities;

public class UmaLeg {
    private String id;
    private String tempo;

    public UmaLeg(String id, String tempo) {
        this.setId(id);
        this.setTempo(tempo);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTempo() {
        return tempo;
    }

    public void setTempo(String tempo) {
        this.tempo = tempo;
    }
}

