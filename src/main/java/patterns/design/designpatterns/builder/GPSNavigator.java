package patterns.design.designpatterns.builder;

public class GPSNavigator {
    private String route;

    public GPSNavigator() {
        this.route = "route";
    }

    public GPSNavigator(String manualRoute) {
        this.route = manualRoute;
    }

    public String getRoute() {
        return route;
    }
}
