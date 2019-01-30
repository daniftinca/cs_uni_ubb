<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html>
            <head>
                <title>Xsl Lab</title>
                <link rel="stylesheet" type="text/css" href="style.css"/>
            </head>
            <body class="body-useless-class">
                <h1 class="useless-class">Lab 3</h1>
                <div class="elements">

                    <xsl:for-each select="root/element">
                        <xsl:if test="position()=1">
                            <div class="element-first">
                                <div class="element-title">
                                    <xsl:value-of select="title"/>
                                </div>
                                <div class="element-value">
                                    <xsl:value-of select="content"/>
                                </div>
                            </div>
                        </xsl:if>
                        <xsl:if test="position()!=1">
                            <div class="element">

                                <div class="element-title">
                                    <xsl:value-of select="title"/>
                                </div>
                                <div class="element-value">
                                    <xsl:value-of select="content"/>
                                </div>

                            </div>
                        </xsl:if>
                    </xsl:for-each>
                </div>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>