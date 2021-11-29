package pl.sda.enumerations.task3;

public class DocumentTypeService {

    public static void main(String[] args) {
        DocumentType documentType = DocumentType.NOTARIAL_ACT;
        System.out.println(DocumentType.getText(documentType));
        System.out.println(documentType.getDescription());
    }
}
