import React, { useState } from "react";
import TextField from "@material-ui/core/TextField";
import Button from "@material-ui/core/Button";
import Axios from "axios";

const AddDrl = () => {
  const [fileName, setFileName] = useState("");
  const [text, setText] = useState("");

  const submit = () => {
    Axios.post("http://localhost:8080/drl", {
      fileName: fileName,
      text: text,
    }).then((response) => alert("Rule has been successfully added"));
  };

  return (
    <div style={{ width: "30%", marginLeft: "auto", marginRight: "auto" }}>
      ADD DRL
      <form style={{ display: "flex", flexDirection: "column" }}>
        <TextField
          className="input"
          label="File name"
          variant="outlined"
          value={fileName}
          onChange={(event) => setFileName(event.target.value)}
        />
        <TextField
          className="input"
          label="Drools..."
          variant="outlined"
          multiline
          rows={4}
          value={text}
          onChange={(event) => setText(event.target.value)}
        />

        <Button
          onClick={submit}
          className="input"
          variant="contained"
          color="primary"
        >
          Submit
        </Button>
      </form>
    </div>
  );
};

export default AddDrl;
