/* Generated By:JJTree: Do not edit this line. OProjection.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=O,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.orientechnologies.orient.core.sql.parser;

import java.util.List;
import java.util.Map;

public class OProjection extends SimpleNode {

  List<OProjectionItem> items;

  public OProjection(int id) {
    super(id);
  }

  public OProjection(OrientSql p, int id) {
    super(p, id);
  }

  /** Accept the visitor. **/
  public Object jjtAccept(OrientSqlVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }

  public List<OProjectionItem> getItems() {
    return items;
  }

  public void setItems(List<OProjectionItem> items) {
    this.items = items;
  }

  @Override
  public String toString() {
    if (items == null) {
      return "";
    }
    boolean first = true;
    StringBuilder builder = new StringBuilder();

    // print * before
    for (OProjectionItem item : items) {
      if (item.isAll()) {
        if (!first) {
          builder.append(", ");
        }

        builder.append(item.toString());
        first = false;
      }
    }

    // and then the rest of the projections
    for (OProjectionItem item : items) {
      if (!item.isAll()) {
        if (!first) {
          builder.append(", ");
        }

        builder.append(item.toString());
        first = false;
      }
    }

    return builder.toString();
  }

  public void replaceParameters(Map<Object, Object> params) {
    if (items != null) {
      for (OProjectionItem item : items) {
        item.replaceParameters(params);
      }
    }
  }
}
/* JavaCC - OriginalChecksum=3a650307b53bae626dc063c4b35e62c3 (do not edit this line) */
