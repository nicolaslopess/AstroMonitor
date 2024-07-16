import React from "react";
import { makeStyles } from '@material-ui/styles';

export const useStyles = makeStyles({
    sidebar:{
        width: 200,
        height: "100%",
        position: "fixed",
        top: 0,
        left: 0,
        backgroundColor: "#111",
        paddingTop: 20,
        zIndex: 1000,
      },
      ul:{
        listStyleType: "none",
        padding: 0,
      },      
      fisrtLi:{
        padding: 8,
        textAlign: "center",
        borderBottom: "1px solid #444",
      },
      click:{
        cursor:"pointer"
      }
      
})