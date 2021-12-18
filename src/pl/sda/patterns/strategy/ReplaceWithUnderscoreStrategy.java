package pl.sda.patterns.strategy;

class ReplaceWithUnderscoreStrategy implements SpacesModificationStrategy {

    @Override
    public void processIfSpace(StringBuilder stringBuilder) {
        stringBuilder.append("_");
    }

    //    @Override
//    public String modify(String input) {
//        final StringBuilder stringBuilder = new StringBuilder();
//        for (char c : input.toCharArray()) {
//            if (c == ' ' ) {
//                stringBuilder.append('_');
//            } else {
//                stringBuilder.append(c);
//            }
//        }
//
//        return stringBuilder.toString();
//    }
}
