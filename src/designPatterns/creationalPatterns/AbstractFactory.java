package designPatterns.creationalPatterns;

// Abstract Product: Button
interface Button {
    void onClick();
}

// Abstract Product: Button
interface CheckBox {
    void onClick();
}

// Concrete Product: Light Theme Button
class LightButton implements Button {
    @Override
    public void onClick() {
        System.out.println("On click a button in light theme");
    }
}

// Concrete Product: Dark Theme Button
class DarkButton implements Button {
    @Override
    public void onClick() {
        System.out.println("On click a button in dark theme");
    }
}

// Concrete Product: Light Theme CheckBox
class LightCheckBox implements CheckBox {
    @Override
    public void onClick() {
        System.out.println("On click a check box in light theme");
    }
}

// Concrete Product: Dark Theme CheckBox
class DarkCheckBox implements CheckBox {
    @Override
    public void onClick() {
        System.out.println("On click a check box in dark theme");
    }
}

// Abstract Factory: GUIFactory
interface GUIFactory {
    Button createButton();

    CheckBox createCheckBox();
}

// Concrete Factory: Light Theme
class LightThemeFactory implements GUIFactory {
    @Override
    public CheckBox createCheckBox() {
        return new LightCheckBox();
    }

    @Override
    public Button createButton() {
        return new LightButton();
    }
}

// Concrete Factory: Dark theme
class DarkThemeFactory implements GUIFactory {
    @Override
    public CheckBox createCheckBox() {
        return new DarkCheckBox();
    }

    @Override
    public Button createButton() {
        return new DarkButton();
    }
}

class AbstractFactory {
    public static void main(String[] args) {
        // Create a Light Theme UI
        GUIFactory lightFactory = new LightThemeFactory();
        Button lightButton = lightFactory.createButton();
        CheckBox lightCheckBox = lightFactory.createCheckBox();

        lightButton.onClick(); // Output: Rendering a button in Light theme.
        lightCheckBox.onClick(); // Output: Rendering a checkbox in Light theme.

        // Create a Dark Theme UI
        GUIFactory darkFactory = new DarkThemeFactory();
        Button darkButton = darkFactory.createButton();
        CheckBox darkCheckbox = darkFactory.createCheckBox();

        darkButton.onClick(); // Output: Rendering a button in Dark theme.
        darkCheckbox.onClick(); // Output: Rendering a checkbox in Dark theme.
    }
}
