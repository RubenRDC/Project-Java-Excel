package com.rubenrdc.lectorexcel.estilos;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.FontUnderline;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Ruben
 */
public class Estilo {

    public static class BuilderCell {

        private HorizontalAlignment alineacionHorizontal = null;
        private VerticalAlignment alineacionVertical = null;
        private BorderStyle bordeIzquierdo, bordeDerecho, bordeSuperior, bordeInferior;
        private String HEXBorderColorIzquierdo, HEXBorderColorDerecho, HEXBorderColorSuperior, HEXBorderColorInferior, HEXColorTexto, HEXColorFondo, FontName, FontFormat;

        private FillPatternType TipoDeRelleno;

        private FontUnderline fontUnderline = FontUnderline.NONE;
        private boolean conBoldText = false, conItalic = false;
        private final short colorPredefinido = IndexedColors.BLACK.getIndex();

        private final String Formato_Dia_Mes_A_H_M = "dd/MM/yyyy HH:mm";
        private final String Formato_Dia_Mes_A_H_M_S = "dd/MM/yyyy HH:mm:ss";
        private final String Formato_Dia_Mes_A = "dd/MM/yyyy";

        private XSSFColor HEXtoXSSFColor(String HEX) {
            if (HEX != null) {
                if (HEX.length() > 0) {
                    try {
                        String hex = HEX.replaceAll("#", "");
                        return new XSSFColor(Hex.decodeHex(hex));
                    } catch (DecoderException ex) {
                        System.out.println(ex);
                    }
                }
            }
            return null;
        }

        private void setAllBorder(XSSFCellStyle a) {
            if (bordeIzquierdo != null) {
                a.setBorderLeft(bordeIzquierdo);
                if (HEXBorderColorIzquierdo != null) {
                    a.setLeftBorderColor(HEXtoXSSFColor(HEXBorderColorIzquierdo));
                }
            }
            if (bordeDerecho != null) {
                a.setBorderRight(bordeDerecho);
                if (HEXBorderColorDerecho != null) {
                    a.setRightBorderColor(HEXtoXSSFColor(HEXBorderColorDerecho));
                }
            }
            if (bordeSuperior != null) {
                a.setBorderTop(bordeSuperior);
                if (HEXBorderColorSuperior != null) {
                    a.setTopBorderColor(HEXtoXSSFColor(HEXBorderColorSuperior));
                }
            }
            if (bordeInferior != null) {
                a.setBorderBottom(bordeInferior);
                if (HEXBorderColorInferior != null) {
                    a.setBottomBorderColor(HEXtoXSSFColor(HEXBorderColorInferior));
                }
            }
        }

        private void setAllAlignment(XSSFCellStyle a) {
            if (alineacionVertical != null) {
                a.setVerticalAlignment(alineacionVertical);
            }
            if (alineacionHorizontal != null) {
                a.setAlignment(alineacionHorizontal);
            }
        }

        private Font setAllFontC(XSSFWorkbook archivoExcel) {
            XSSFFont createFont = archivoExcel.createFont();
            if (HEXtoXSSFColor(HEXColorTexto) != null) {
                createFont.setColor(HEXtoXSSFColor(HEXColorTexto));
            } else {
                createFont.setColor(colorPredefinido);
            }
            createFont.setItalic(conItalic);
            createFont.setBold(conBoldText);
            createFont.setUnderline(fontUnderline);
            if (FontName != null) {
                createFont.setFontName(FontName);
            }
            return createFont;
        }

        public XSSFCellStyle contruirEstilo(XSSFWorkbook archivoExcel) {
            XSSFCellStyle CellStyle = archivoExcel.createCellStyle();
            setAllBorder(CellStyle);
            setAllAlignment(CellStyle);
            CellStyle.setFont(setAllFontC(archivoExcel));
            if (FontFormat != null) {
                CellStyle.setDataFormat(archivoExcel.createDataFormat().getFormat(FontFormat));
            }
            if (HEXColorFondo != null) {
                CellStyle.setFillBackgroundColor(HEXtoXSSFColor(HEXColorFondo));
            }
            if (TipoDeRelleno != null) {
                CellStyle.setFillPattern(TipoDeRelleno);
            }

            return CellStyle;
        }

        public BuilderCell() {
        }//Constructor por defector

        public BuilderCell setAlineacionHorizontal(HorizontalAlignment alineacionHorizontal) {
            this.alineacionHorizontal = alineacionHorizontal;
            return this;
        }

        public BuilderCell setAlineacionVertical(VerticalAlignment alineacionVertical) {
            this.alineacionVertical = alineacionVertical;
            return this;
        }

        public BuilderCell setBordeIzquierdo(BorderStyle bordeIzquierdo) {
            this.bordeIzquierdo = bordeIzquierdo;
            return this;
        }

        public BuilderCell setBordeDerecho(BorderStyle bordeDerecho) {
            this.bordeDerecho = bordeDerecho;
            return this;
        }

        public BuilderCell setBordeSuperior(BorderStyle bordeSuperior) {
            this.bordeSuperior = bordeSuperior;
            return this;
        }

        public BuilderCell setBordeInferior(BorderStyle bordeInferior) {
            this.bordeInferior = bordeInferior;
            return this;
        }

        public BuilderCell setColorBordeIzquierdo(String HEXBorderColorIzquierdo) {
            this.HEXBorderColorIzquierdo = HEXBorderColorIzquierdo;
            return this;
        }

        public BuilderCell setColorBordeDerecho(String HEXBorderColorDerecho) {
            this.HEXBorderColorDerecho = HEXBorderColorDerecho;
            return this;
        }

        public BuilderCell setColorBordeSuperior(String HEXBorderColorSuperior) {
            this.HEXBorderColorSuperior = HEXBorderColorSuperior;
            return this;
        }

        public BuilderCell setColorBordeInferior(String HEXBorderColorInferior) {
            this.HEXBorderColorInferior = HEXBorderColorInferior;
            return this;
        }

        public BuilderCell setFontName(String FontName) {
            this.FontName = FontName;
            return this;
        }

        public BuilderCell setFontFormat(String FontFormat) {
            this.FontFormat = FontFormat;
            return this;
        }

        public BuilderCell setFontUnderline(FontUnderline fontUnderline) {
            this.fontUnderline = fontUnderline;
            return this;
        }

        public BuilderCell setBoldText(boolean BoldText) {
            this.conBoldText = BoldText;
            return this;
        }

        public BuilderCell setItalic(boolean Italic) {
            this.conItalic = Italic;
            return this;
        }

        public BuilderCell setColorFondoHEX(String HEXColorFondo) {
            this.HEXColorFondo = HEXColorFondo;
            return this;
        }

        public BuilderCell setTipoDeRellenoFondo(FillPatternType TipoDeRelleno) {
            this.TipoDeRelleno = TipoDeRelleno;
            return this;
        }
        
        public BuilderCell setColorText(String HEXColorText){
            this.HEXColorTexto = HEXColorText;
            return this;
        }
    }

}
