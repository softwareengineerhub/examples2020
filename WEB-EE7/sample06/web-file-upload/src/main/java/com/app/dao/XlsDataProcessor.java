package com.app.dao;

import com.app.model.User;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class XlsDataProcessor extends AbstractDataProcessor {

    @Override
    protected List<User> parse(InputStream in) {

        List<User> users = new ArrayList<>();

        try {
            Workbook workbook = new XSSFWorkbook(in);
            Sheet datatypeSheet = workbook.getSheetAt(0);

            for (Row currentRow : datatypeSheet) {

                User user;
                String name = null;
                String password = null;
                String role = null;


                for (Cell currentCell : currentRow) {

                    if (currentCell.getCellTypeEnum() == CellType.STRING) {
                        switch (currentCell.getColumnIndex()) {
                            case 0:
                                name = currentCell.getStringCellValue();
                                break;
                            case 1:
                                password = currentCell.getStringCellValue();
                                break;
                            case 2:
                                role = currentCell.getStringCellValue();
                        }
                    }

                }
                if (!(name==null || password==null|| role==null)) {
                    user = new User(name,  role, password);
                    users.add(user);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }
}
