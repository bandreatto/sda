package pl.sda.enumerations.task4;

public enum PackageSize {

    SMALL(0, 5),
    MEDIUM(6, 10),
    LARGE(11, 100);

    private int min;
    private int max;

    PackageSize(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public static PackageSize getPackageSize(int packageMin, int packageMax) {
        // zalozenie: packageMin <= packageMax
        PackageSize[] packageSizes = values();
        for (int i = 0; i < packageSizes.length; i++) {
            if (packageSizes[i].min <= packageMin && packageSizes[i].max >= packageMax) {
                return packageSizes[i];
            }
        }

        return null;
    }

    public static void main(String[] args) {
        PackageSize packageSize = PackageSize.getPackageSize(7, 8);
        System.out.println(packageSize);
    }
}
