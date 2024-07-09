import { makeStyles } from '@material-ui/styles';

export const useStyles = makeStyles({
  sidebar: {
    width: 200,
    height: "100%",
    position: "fixed",
    top: 0,
    left: 0,
    backgroundColor: "#111",
    paddingTop: 20,
    zIndex: 1000,
    transition: 'left 0.3s',
  },
  title:{
    color: 'white', 
    fontSize:"1.5rem", 
  },
  tableInfo: {
    marginTop: 5,
    display:"flex",
    paddingBottom: 10,
  },
  tableLabelsHeader: {
    fontWeight: 600,
    fontSize: 16,
    color: "#919EAB"
  },
  block: {
    display: "flex",
    justifyContent: "flex-start",
    width: "100%",
  },
  open: {
    left: 0,
  },
  closeBtn: {
    position: "absolute",
    top: 10,
    right: 10,
    background: "none",
    border: "none",
    color: "white",
    fontSize: 20,
  },
  ul: {
    listStyleType: "none",
    padding: 0,
  },
  fisrtLi: {
    padding: 8,
    textAlign: "center",
    borderBottom: "1px solid #444",
  },
  hamburgerBtn: {
    position: "fixed",
    top: 20,
    left: 20,
    zIndex: 1001,
    background: "none",
    border: "none",
    color: "white",
    fontSize: 30,
    cursor: "pointer",
  },
});
