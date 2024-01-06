package SymbolTableStructure;

import java.util.HashMap;
import java.util.Map;

public class SymbolTable2 {

    private Map<String, Object> symbolTable;

    public SymbolTable2() {
        this.symbolTable = new HashMap<>();
    }

    // Function to add a variable and its value to the symbol table
    public void addVariable(String variableName, Object value) {
        symbolTable.put(variableName, value);
    }

    // Function to update the value of an existing variable in the symbol table
    public void updateVariable(String variableName, Object newValue) {
        if (symbolTable.containsKey(variableName)) {
            symbolTable.put(variableName, newValue);
        } else {
            System.out.println("Variable " + variableName + " does not exist in the symbol table.");
        }
    }

    // Function to get the value of a variable from the symbol table
    public Object getValue(String variableName) {
        if (symbolTable.containsKey(variableName)) {
            return symbolTable.get(variableName);
        } else {
            System.out.println("Variable " + variableName + " does not exist in the symbol table.");
            return null;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Symbol Table:\n");
        stringBuilder.append("*").append("*".repeat(180)).append("*\n");
        stringBuilder.append(String.format("| %-65s | %-65s \n", "Variable Name", "Value"));
        stringBuilder.append("*").append("*".repeat(180)).append("*\n");

        for (Map.Entry<String, Object> entry : symbolTable.entrySet()) {
            String value = String.valueOf(entry.getValue());

            String[] valueLines = value.split("\\n");
            int maxValueLines = Math.max(valueLines.length, 1);

            String[] variableNameLines = entry.getKey().split("\\n");
            int maxVariableNameLines = Math.max(variableNameLines.length, 1);

            int maxLines = Math.max(maxValueLines, maxVariableNameLines);

            for (int i = 0; i < maxLines; i++) {
                String variableName = (i < variableNameLines.length) ? variableNameLines[i] : "";
                String valueLine = (i < valueLines.length) ? valueLines[i] : "";

                stringBuilder.append(String.format("| %-65s | %-65s \n", variableName, valueLine));
            }

            stringBuilder.append("*").append("*".repeat(180)).append("*\n");
        }

        return stringBuilder.toString();
    }


}
