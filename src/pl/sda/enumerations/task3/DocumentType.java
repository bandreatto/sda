package pl.sda.enumerations.task3;

public enum DocumentType {
    CONTRACT,
    INVOICE,
    NOTARIAL_ACT,
    CERTIFICATE;

    public String getDescription() {
        String name = name();
        return "You selected " + name.toLowerCase().replace("_", " ");
    }

    public static String getText(DocumentType documentType) {
        switch (documentType) {
            case CONTRACT:
                return "You selected contract";
            case INVOICE:
                return "You selected invoice";
            case NOTARIAL_ACT:
                return "You selected notarial act";
            case CERTIFICATE:
                return "You selected notarial certificate";
            default:
                return "unknown!";
        }
    }
}
