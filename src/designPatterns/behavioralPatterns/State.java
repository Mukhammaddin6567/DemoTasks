package designPatterns.behavioralPatterns;

interface MediaPlayerState {
    void pressPlay(MediaPlayerContext context);

    void pressPause(MediaPlayerContext context);

    void pressStop(MediaPlayerContext context);
}

class PlayingState implements MediaPlayerState {
    @Override
    public void pressStop(MediaPlayerContext context) {
        System.out.println("Stopping Media...");
        context.setState(new StoppedState());
    }

    @Override
    public void pressPause(MediaPlayerContext context) {
        System.out.println("Pausing Media...");
        context.setState(new PausedState());
    }

    @Override
    public void pressPlay(MediaPlayerContext context) {
        System.out.println("Media is already playing");
    }
}

class PausedState implements MediaPlayerState {
    @Override
    public void pressStop(MediaPlayerContext context) {
        System.out.println("Stopping Media...");
        context.setState(new StoppedState());
    }

    @Override
    public void pressPause(MediaPlayerContext context) {
        System.out.println("Media is already paused");
    }

    @Override
    public void pressPlay(MediaPlayerContext context) {
        System.out.println("Playing Media...");
        context.setState(new PlayingState());
    }
}

class StoppedState implements MediaPlayerState {
    @Override
    public void pressStop(MediaPlayerContext context) {
        System.out.println("Media is already stopped");
    }

    @Override
    public void pressPause(MediaPlayerContext context) {
        System.out.println("Media is Stopped! Can't Pause.");
        context.setState(new PausedState());
    }

    @Override
    public void pressPlay(MediaPlayerContext context) {
        System.out.println("Playing Media...");
        context.setState(new PlayingState());
    }
}

class MediaPlayerContext {
    private MediaPlayerState state;

    MediaPlayerContext() {
        this.state = new StoppedState(); // Default state
    }

    void setState(MediaPlayerState state) {
        this.state = state;
    }

    void pressPlay() {
        this.state.pressPlay(this);
    }

    void pressPause() {
        this.state.pressPause(this);
    }

    void pressStop() {
        this.state.pressStop(this);
    }
}

class State {
    public static void main(String[] args) {
        MediaPlayerContext mediaPlayer = new MediaPlayerContext();

        mediaPlayer.pressPlay();
        mediaPlayer.pressPause();
        mediaPlayer.pressPlay();
        mediaPlayer.pressStop();
        mediaPlayer.pressPause();
        mediaPlayer.pressPause();
    }
}
