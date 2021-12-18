package pl.sda.patterns.strategy;

class DoubleSpacesStrategy implements SpacesModificationStrategy {

    @Override
    public void processIfSpace(StringBuilder stringBuilder) {
        stringBuilder.append("  ");
    }

    //    @Override
//    public String modify(String input) {
//        final StringBuilder stringBuilder = new StringBuilder();
//        for (char c : input.toCharArray()) {
//            if (c != ' ' ) {
//                stringBuilder.append(c);
//            } else {
//                stringBuilder.append("  ");
//            }
//        }
//
//        return stringBuilder.toString();
//    }
}
